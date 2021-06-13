package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UnblockCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("block command");
        HttpSession session = req.getSession();

        long userId = Long.parseLong(req.getParameter("userId"));

        User user = DaoFactory.createUserDao().findUserByID(userId);
        user.setStatus(false);
        DaoFactory.createUserDao().updateUser(user);

        return Path.COMMAND_PAGE_USERS;
    }
}
