package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubscribeCommand implements Command {

    private static final Logger log = LogManager.getLogger(SubscribeCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("SubscribeCommand starts");
        HttpSession session = req.getSession();

        String periodicalIdStr = req.getParameter("periodicalId");
        log.trace("periodicalIdStr ==> " + periodicalIdStr);
        long periodicalId = Long.parseLong(req.getParameter("periodicalId"));
        log.trace("periodicalId ==> " + periodicalId);

        User user = (User) session.getAttribute("user");
        long userId = user.getId();

        if (DaoFactory.createSubscriptionDao().isSubscribed(userId, periodicalId)) {
            log.debug("user is already subscribed, forward to error page");
            return Path.PAGE_SUBSCRIBED_USER;
        }

        session.setAttribute("periodical", DaoFactory.createPeriodicalDao().findPeriodicalById(periodicalId));

        log.debug("SubscribeCommand finished");
        return Path.PAGE_SUBSCRIBE;
    }
}
