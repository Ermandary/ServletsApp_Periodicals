package com.ermanadary.dao;

import com.ermanadary.entity.User;

import java.util.List;

public interface UserDao {
    User findUserByID(long id);

    User findUserByEmail(String email);

    List<User> findAllUsers();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean updateUserWithoutBalance(User user);
}
