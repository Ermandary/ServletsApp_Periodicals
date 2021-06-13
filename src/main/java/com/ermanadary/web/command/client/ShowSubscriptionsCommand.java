package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSubscriptionsCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
//        session.setAttribute("subscriptions", DaoFactory.createSubscriptionDao().findSubscriptionsByUserId(user.getId()));
        session.setAttribute("subscriptionsInfo", DaoFactory.createSubscriptionDao().getSubscriptionsInfo(user.getId()));
        return Path.PAGE_SUBSCRIPTIONS;
    }
}
