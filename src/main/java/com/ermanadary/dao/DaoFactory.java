package com.ermanadary.dao;

import com.ermanadary.dao.impl.mysql.MySqlPaymentDao;
import com.ermanadary.dao.impl.mysql.MySqlPeriodicalDao;
import com.ermanadary.dao.impl.mysql.MySqlSubscriptionDao;
import com.ermanadary.dao.impl.mysql.MySqlUserDao;

public class DaoFactory {

    public static PaymentDao createPaymentDao() {
        return new MySqlPaymentDao();
    }

    public static PeriodicalDao createPeriodicalDao() {
        return new MySqlPeriodicalDao();
    }

    public static SubscriptionDao createSubscriptionDao() {
        return new MySqlSubscriptionDao();
    }

    public static UserDao createUserDao() {
        return new MySqlUserDao();
    }
}
