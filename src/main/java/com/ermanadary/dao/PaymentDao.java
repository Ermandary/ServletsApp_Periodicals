package com.ermanadary.dao;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.entity.Payment;
import com.ermanadary.entity.Subscription;

public interface PaymentDao {
    boolean addPayment(Payment payment) throws DBException;

    boolean addPaymentBySubscription(Payment payment, Subscription subscription) throws DBException;

    boolean createPayment(Payment payment, Subscription subscription) throws DBException;
}
