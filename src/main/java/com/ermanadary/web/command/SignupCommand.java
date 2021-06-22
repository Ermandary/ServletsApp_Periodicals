package com.ermanadary.web.command;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.dao.UserDao;
import com.ermanadary.entity.Gender;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupCommand implements Command {

    private static final Logger log = LogManager.getLogger(SignupCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("SignupCommand starts");
        String address = "signup.jsp";

        String methodthodName = req.getMethod();
        log.trace("input method ==> " + methodthodName);

        if (methodthodName.equals("GET")) {
            return Path.PAGE_SIGN_UP;
        }

        String email = req.getParameter("email");
        log.trace("email ==> " + email);

        String firstName = req.getParameter("first_name");
        log.trace("firstName ==> " + firstName);

        String lastName = req.getParameter("last_name");
        log.trace("lastName ==> " + lastName);

        Gender gender = Gender.valueOf(req.getParameter("gender").toUpperCase());
        log.trace("gender ==> " + gender);

        String password = req.getParameter("password");
        log.trace("password ==> " + password);

        User user = new User();
        user.setRoleId(1);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setPassword(password);

        UserDao userDao = DaoFactory.createUserDao();

        boolean isAdd = userDao.addUser(user);

        if (isAdd) {
            address = Path.PAGE_LOGIN;
        }

        log.debug("SignupCommand finished");
        return address;
    }
}
