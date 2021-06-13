package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubscribeCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("SubscribeCommand");
        HttpSession session = req.getSession();

        System.out.println("id перед преобразованием ==> " + req.getParameter("periodicalId"));
        long periodicalId = Long.parseLong(req.getParameter("periodicalId"));
        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        if(DaoFactory.createSubscriptionDao().isSubscribed(userId, periodicalId)) {
            return Path.PAGE_ERROR;
        }


        System.out.println("id == > " + periodicalId);

        session.setAttribute("periodical", DaoFactory.createPeriodicalDao().findPeriodicalById(periodicalId));

        return Path.PAGE_SUBSCRIBE;
    }
}
