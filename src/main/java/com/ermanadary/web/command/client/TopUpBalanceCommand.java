package com.ermanadary.web.command.client;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class TopUpBalanceCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("TopUpBalance");

        String methodthodName = req.getMethod();
        System.out.println("input method ==> " + methodthodName);

        if (methodthodName.equals("GET")) {
            return Path.PAGE_TOP_UP_BALANCE;
        }

        HttpSession session = req.getSession();
        BigDecimal amount = new BigDecimal(req.getParameter("amount"));
        User user = (User) session.getAttribute("user");

        user.setBalance(user.getBalance().add(amount));

//        user.setBalance(new BigDecimal(Integer.parseInt(amount)));
        DaoFactory.createUserDao().updateUser(user);
        session.setAttribute("user", user);

        return Path.COMMAND_MAIN_PAGE;
    }
}
