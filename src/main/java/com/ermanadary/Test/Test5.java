package com.ermanadary.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Dima", 25));
        users.add(new User("Yuriy", 15));
        users.add(new User("ALex", 20));
        users.add(new User("Boris", 35));

        Collections.sort(users, Comparator.comparing(User::getName));
        for (User user: users) {
            System.out.println(user);
        }
        Collections.sort(users, Comparator.comparing(User::getAge));
        for (User user: users) {
            System.out.println(user);
        }

    }
}
