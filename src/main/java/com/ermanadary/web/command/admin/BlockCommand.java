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

public class BlockCommand implements Command {

    private static final Logger log = LogManager.getLogger(BlockCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("BlockCommand starts");
        HttpSession session = req.getSession();

        long userId = Long.parseLong(req.getParameter("userId"));

        User user = DaoFactory.createUserDao().findUserByID(userId);
        log.trace("user ==> " + user);
        user.setStatus(true);
        DaoFactory.createUserDao().updateUser(user);

        log.debug("BlockCommand starts");
        return Path.COMMAND_PAGE_USERS;
    }
}
