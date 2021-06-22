package com.ermanadary.dao;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.entity.User;

import java.util.List;

public interface UserDao {
    User findUserByID(long id) throws DBException;

    User findUserByEmail(String email) throws DBException;

    List<User> findAllUsers() throws DBException;

    boolean addUser(User user) throws DBException;

    boolean updateUser(User user) throws DBException;

    boolean updateUserWithoutBalance(User user) throws DBException;
}
