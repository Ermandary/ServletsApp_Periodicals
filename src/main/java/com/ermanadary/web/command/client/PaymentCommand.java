package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.entity.SubscriptionPeriod;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentCommand implements Command {

    private static final Logger log = LogManager.getLogger(PaymentCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("PaymentCommand starts");

        String methodName = req.getMethod();
        log.trace("input method ==> " + methodName);

        if (methodName.equals("GET")) {
            return Path.PAGE_PAYMENT;
        }

        SubscriptionPeriod subscriptionPeriod = SubscriptionPeriod.valueOf(req.getParameter("subscriptionType"));
        HttpSession session = req.getSession();
        log.trace("subscription period ==> " + subscriptionPeriod);

        session.setAttribute("subscriptionPeriod", subscriptionPeriod);

        log.debug("PaymentCommand finished");
        return Path.COMMAND_PAYMENT;
    }
}
