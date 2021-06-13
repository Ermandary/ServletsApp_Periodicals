package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.entity.SubscriptionPeriod;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("PaymentCommand");

        String methodthodName = req.getMethod();
        System.out.println("input method ==> " + methodthodName);

        if (methodthodName.equals("GET")) {
            return Path.PAGE_PAYMENT;
        }

        SubscriptionPeriod subscriptionPeriod = SubscriptionPeriod.valueOf(req.getParameter("subscriptionType"));
        HttpSession session = req.getSession();
        System.out.println("subscription period ...");
        System.out.println(subscriptionPeriod.getPeriodDescription());
        System.out.println("subscription number");
        System.out.println(subscriptionPeriod.getNumber());

        session.setAttribute("subscriptionPeriod", subscriptionPeriod);

        return Path.COMMAND_PAYMENT;
    }
}
