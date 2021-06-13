package com.ermanadary.web.filter;

import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.Role;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccessFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(AccessFilter.class);

    private static final Map<Role, List<String>> accessMap = new ConcurrentHashMap<>();
    private static List<String> outOfControl = new CopyOnWriteArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("AccessFilter init...");
        accessMap.put(Role.ADMIN, asList(filterConfig.getInitParameter("admin")));
        accessMap.put(Role.CLIENT, asList(filterConfig.getInitParameter("client")));
        System.out.println("мапа доступа ==> " + accessMap.toString());

        outOfControl = asList(filterConfig.getInitParameter("out-of-control"));
        System.out.println("Команды без контроля ==> " + outOfControl.toString());
        outOfControl.forEach(System.out::println);
        System.out.println("Инициализация фильтра доступа закончена");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("AccessFilter is starting..");
        HttpServletRequest req = (HttpServletRequest) request;

        if (checkAccess(req, response)) {
            System.out.println("доступ есть, вызываем следующий фильтр");
            chain.doFilter(request, response);
        } else {
            System.out.println("доступа нету, направляем на страницу с ошибкой");
            String errorMessasge = "You do not have permission to access the requested resource";

            request.setAttribute("errorMessage", errorMessasge);

            request.getRequestDispatcher(Path.PAGE_ERROR_ACCESS)
                    .forward(request, response);
        }
    }

    private boolean checkAccess(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("проверяем доступ к команде");

        String commandName = request.getParameter("command");
        System.out.println("пришла команда ==> " + commandName);

        if (outOfControl.contains(commandName)) {
            System.out.println("пришла команда не требующая доступа");
            return true;
        }

        HttpSession session = request.getSession(false);

        if(session == null) {
            System.out.println("session is null");
            return false;
        }

        User user = (User) session.getAttribute("user");
        if(user == null) {
            System.out.println("user is null");
            return false;
        }

        if (commandName == null || commandName.isEmpty()) {
            System.out.println("command is null");
            return false;
        }

        //Update user info
        user = DaoFactory.createUserDao().findUserByID(user.getId());

        Role userRole = Role.getRole(user);
        System.out.println("user role ==>" + userRole);

        System.out.println(user);
        System.out.println(user.isStatus());
        if (user.isStatus()) {
            System.out.println("юзер заблокирвоан");
            request.getRequestDispatcher(Path.PAGE_BLOCKED_USER)
                    .forward(request, response);
        }
        System.out.println("юзер не заблокирован");

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