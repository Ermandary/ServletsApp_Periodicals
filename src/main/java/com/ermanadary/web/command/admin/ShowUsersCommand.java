package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowUsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {

        List<User> users = DaoFactory.createUserDao().findAllUsers();
        HttpSession session = req.getSession();

        session.setAttribute("users", users);

        return Path.PAGE_USERS;
    }
}
