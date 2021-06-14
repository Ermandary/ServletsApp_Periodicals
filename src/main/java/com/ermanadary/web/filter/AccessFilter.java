package com.ermanadary.web.filter;

import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.Role;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccessFilter implements Filter {

    private static final Logger log = LogManager.getLogger(AccessFilter.class);

    private static final Map<Role, List<String>> accessMap = new ConcurrentHashMap<>();
    private static List<String> outOfControl = new CopyOnWriteArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) {
        log.debug("AccessFilter init...");

        accessMap.put(Role.ADMIN, asList(filterConfig.getInitParameter("admin")));
        accessMap.put(Role.CLIENT, asList(filterConfig.getInitParameter("client")));

        outOfControl = asList(filterConfig.getInitParameter("out-of-control"));
        log.trace("out of control commands ==> " + outOfControl);

        log.debug("AccessFilter init finished");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("AccessFilter is starting..");

        HttpServletRequest req = (HttpServletRequest) request;

        if (checkAccess(req, response)) {
            log.debug("access is allowed");
            chain.doFilter(request, response);
        } else {
            log.debug("access is denied");
            String errorMessasge = "You do not have permission to access the requested resource";

            request.setAttribute("errorMessage", errorMessasge);

            request.getRequestDispatcher(Path.PAGE_ERROR_ACCESS)
                    .forward(request, response);
        }
    }

    private boolean checkAccess(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.debug("checkAccess...");

        String commandName = request.getParameter("command");
        log.trace("commandName ==> " + commandName);

        if (outOfControl.contains(commandName)) {
            log.debug("this command does not require access");
            return true;
        }

        HttpSession session = request.getSession(false);

        if(session == null) {
            log.debug("session is null");
            return false;
        }

        User user = (User) session.getAttribute("user");
        if(user == null) {
            log.debug("user is null");
            return false;
        }

        if (commandName == null || commandName.isEmpty()) {
            log.debug("command is null");
            return false;
        }

        //Update user info
        user = DaoFactory.createUserDao().findUserByID(user.getId());
        log.trace("user ==>" + user);

        Role userRole = Role.getRole(user);

        if (user.isStatus()) {
            log.debug("user is blocked");
            request.getRequestDispatcher(Path.PAGE_BLOCKED_USER)
                    .forward(request, response);
        }

        log.debug("user is not blocked");
        return accessMap.get(userRole).contains(commandName);
    }

    @Override
    public void destroy() {
        System.out.println("AccessFilter destroy...");
    }

    private List<String> asList(String str) {
        List<String> list = new CopyOnWriteArrayList<>();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) list.add(st.nextToken());
        return list;
    }
}