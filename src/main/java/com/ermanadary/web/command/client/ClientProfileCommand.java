package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientProfileCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("CLientProfileCommand  - смотрим атрибуты сессии");
        User user = (User) req.getSession().getAttribute("user");
        System.out.println("user is null?");
        System.out.println("user is null? ");
        System.out.println(user == null);
        System.out.println(user);
        return Path.PAGE_CLIENT_PROFILE;
    }
}
