package com.ermanadary.web.command.client;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSubscriptionsCommand implements Command {

    private static final Logger log = LogManager.getLogger(ShowSubscriptionsCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("ShowSubscriptionsCommand starts");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        log.trace("user ==> " + user);
        session.setAttribute("subscriptionsInfo", DaoFactory.createSubscriptionDao().getSubscriptionsInfo(user.getId()));

        log.debug("ShowSubscriptionsCommand finished");
        return Path.PAGE_SUBSCRIPTIONS;
    }
}
