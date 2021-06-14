package com.ermanadary.web.command;

import com.ermanadary.DBException;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.client.TopUpBalanceCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockedUserCommand implements Command{

    private static final Logger log = LogManager.getLogger(BlockedUserCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("BlockedUserCommand");
        return Path.COMMAND_BLOCKED_USER;
    }
}
