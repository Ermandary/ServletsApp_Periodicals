package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientPageCommand implements Command {

    private static final Logger log = LogManager.getLogger(ClientPageCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("ClientPageCommand");
        return Path.PAGE_CLIENT;
    }
}