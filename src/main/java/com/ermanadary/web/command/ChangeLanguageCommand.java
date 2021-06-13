package com.ermanadary.web.command;

import com.ermanadary.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguageCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        return null;
    }
}
