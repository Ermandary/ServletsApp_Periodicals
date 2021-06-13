package com.ermanadary.dao;

import com.ermanadary.entity.Payment;
import com.ermanadary.entity.Subscription;

public interface PaymentDao {
    boolean addPayment(Payment payment);

    boolean addPaymentBySubscription(Payment payment, Subscription subscription);

    boolean createPayment(Payment payment, Subscription subscription);
}
