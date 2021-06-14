package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.Payment;
import com.ermanadary.entity.Periodical;
import com.ermanadary.entity.Subscription;
import com.ermanadary.entity.SubscriptionPeriod;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

public class PaymentFormCommand implements Command {

    private static final Logger log = LogManager.getLogger(PaymentFormCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("PaymentFormCommand starts");

        HttpSession session = req.getSession();
        Periodical periodical = (Periodical) session.getAttribute("periodical");
        User user = (User) session.getAttribute("user");
        SubscriptionPeriod subscriptionPeriod = (SubscriptionPeriod) session.getAttribute("subscriptionPeriod");

        Calendar currentDate = Calendar.getInstance();
        Subscription subscription = createSubscription(user.getId(), periodical.getId(), subscriptionPeriod, currentDate);
        Payment payment = createPayment(user.getId(), currentDate, periodical.getPrice(), subscriptionPeriod.getNumber());

        if (!checkBalance(user.getBalance(), payment.getTotalPrice())) {
            log.debug("not enough money on the balance, forward to top up balance");
            return Path.PAGE_TOP_UP_BALANCE;
        }

        DaoFactory.createPaymentDao().createPayment(payment, subscription);

        updateBalance(user, payment.getTotalPrice());
        session.setAttribute("user", user);

        log.debug("PaymentFormCommand finished");
        return Path.PAGE_CLIENT;
    }

    private Subscription createSubscription(long userId, long periodicalId, SubscriptionPeriod subscriptionPeriod, Calendar currentDate) {
        Subscription subscription = new Subscription();

        Timestamp startDate = new Timestamp(currentDate.getTime().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, subscriptionPeriod.getNumber());
        Timestamp endDate = new Timestamp(calendar.getTime().getTime());

        subscription.setStatus(true);
        subscription.setUserId(userId);
        subscription.setPeriodicalId(periodicalId);
        subscription.setPeriod(subscriptionPeriod);
        subscription.setStartDate(startDate);
        subscription.setEndDate(endDate);
        return subscription;
    }

    private Payment createPayment(long userId, Calendar currentDate, BigDecimal price, int numberOfMonths) {
        Payment payment = new Payment();

        Timestamp paymentDate = new Timestamp(currentDate.getTime().getTime());

        payment.setUserId(userId);
        payment.setPaymentDateTime(paymentDate);
        payment.setTotalPrice(price.multiply(new BigDecimal(numberOfMonths)));

        return payment;
    }

    private void updateBalance(User user, BigDecimal totalPrice) {
        BigDecimal resultBalance = user.getBalance().subtract(totalPrice);
        user.setBalance(resultBalance);
        DaoFactory.createUserDao().updateUser(user);
    }

    private boolean checkBalance(BigDecimal userBalance, BigDecimal totalPrice) {
        if (userBalance.compareTo(totalPrice) < 0) {
            return false;
        }
        return true;
    }
}
