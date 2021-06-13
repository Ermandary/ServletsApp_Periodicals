package com.ermanadary.web.command;

import com.ermanadary.DBException;
import com.ermanadary.web.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockedUserCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        return Path.COMMAND_BLOCKED_USER;
    }
}
