package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {

//        req.getSession().setAttribute("periodicals", DaoFactory.createPeriodicalDao().findAllPeriodicals());

        return Path.PAGE_CLIENT;
    }
}