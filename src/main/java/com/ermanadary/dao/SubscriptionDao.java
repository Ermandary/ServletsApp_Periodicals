package com.ermanadary.dao;

import com.ermanadary.DBException;
import com.ermanadary.entity.Subscription;
import com.ermanadary.entity.SubscriptionInfo;

import java.util.List;

public interface SubscriptionDao {
    boolean addSubscription(Subscription subscription) throws DBException;

    List<Subscription> findSubscriptionsByUserId(long userId) throws DBException;
    List<SubscriptionInfo> getSubscriptionsInfo(long userId) throws DBException;
    boolean isSubscribed(long userId, long periodicalId) throws DBException;
}
