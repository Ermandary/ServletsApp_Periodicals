package com.ermanadary.web.command.client;

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
import java.math.BigDecimal;

public class TopUpBalanceCommand implements Command {

    private static final Logger log = LogManager.getLogger(TopUpBalanceCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("TopUpBalanceCommand starts");

        String methodName = req.getMethod();
        log.trace("input method ==> " + methodName);

        if (methodName.equals("GET")) {
            return Path.PAGE_TOP_UP_BALANCE;
        }

        HttpSession session = req.getSession();
        BigDecimal amount = new BigDecimal(req.getParameter("amount"));
        log.trace("amount ==> " + amount);
        User user = (User) session.getAttribute("user");
        log.trace("user ==> " + user);
        user.setBalance(user.getBalance().add(amount));

        DaoFactory.createUserDao().updateUser(user);
        session.setAttribute("user", user);

        log.debug("TopUpBalanceCommand finished");
        return Path.COMMAND_MAIN_PAGE;
    }
}
