package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UnblockCommand implements Command {

    private static final Logger log = LogManager.getLogger(UnblockCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("UnblockCommand starts");
        HttpSession session = req.getSession();

        long userId = Long.parseLong(req.getParameter("userId"));
        log.trace("userId ==> " + userId);

        User user = DaoFactory.createUserDao().findUserByID(userId);
        user.setStatus(false);
        DaoFactory.createUserDao().updateUser(user);

        log.debug("UnblockCommand finished");
        return Path.COMMAND_PAGE_USERS;
    }
}
