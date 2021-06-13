package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePeriodical implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        long periodicalId = Long.parseLong(req.getParameter("periodicalId"));

        DaoFactory.createPeriodicalDao().deletePeriodicalById(periodicalId);

        return Path.COMMAND_MAIN_PAGE;
    }
}
