package com.ermanadary.web.command;

import com.ermanadary.DBException;
import com.ermanadary.web.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        HttpSession session = req.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return Path.PAGE_LOGIN;
    }
}
