package com.ermanadary.web.command;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.dao.UserDao;
import com.ermanadary.entity.Role;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("LoginCommand#execute");
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        System.out.println("email ==> " + email);
        String password = req.getParameter("password");
        System.out.println("password ==> " + password);

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            String errorMessage = "Login/password cannot be empty";
            req.setAttribute("errorMessage", errorMessage);
            System.out.println(errorMessage);
            return Path.PAGE_LOGIN;
        }

        UserDao userDao = DaoFactory.createUserDao();
        User user = userDao.findUserByEmail(email);
        System.out.println("найденный юзер ==> " + user);

        // если не null, вызывай init и делай сессию
        if (user == null || !password.equals(user.getPassword())) {
            System.out.println("user is null или неверный пароль, возвращаем на страницу регистрации");
            return Path.PAGE_LOGIN;
        }

        initSession(session, user);

        return Path.COMMAND_MAIN_PAGE;
    }


    private void initSession(HttpSession session, User user) {
        Role userRole = Role.getRole(user);
        System.out.println("userRole ==> " + userRole);

        session.setAttribute("user", user);
        System.out.println("в сессию установлени юзер ==> " + user);

        session.setAttribute("userRole", userRole);
        System.out.println("в сессию установлена роль ==> " + userRole);
    }
}
