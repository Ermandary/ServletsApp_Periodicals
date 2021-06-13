package com.ermanadary.dao;

import com.ermanadary.entity.Subscription;
import com.ermanadary.entity.SubscriptionInfo;

import java.util.List;

public interface SubscriptionDao {
    boolean addSubscription(Subscription subscription);

    List<Subscription> findSubscriptionsByUserId(long userId);
    List<SubscriptionInfo> getSubscriptionsInfo(long userId);
    boolean isSubscribed(long userId, long periodicalId);
}
