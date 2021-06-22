package com.ermanadary.web.command.admin;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPageCommand implements Command {

    private static final Logger log = LogManager.getLogger(AdminPageCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("AdminPageCommand");
        return Path.PAGE_ADMIN;
    }
}
