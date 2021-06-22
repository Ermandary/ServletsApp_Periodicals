package com.ermanadary.web.command.admin;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowUsersCommand implements Command {

    private static final Logger log = LogManager.getLogger(ShowUsersCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("ShowUsersCommand starts");

        List<User> users = DaoFactory.createUserDao().findAllUsers();
        HttpSession session = req.getSession();

        session.setAttribute("users", users);

        log.debug("ShowUsersCommand finished");
        return Path.PAGE_USERS;
    }
}
