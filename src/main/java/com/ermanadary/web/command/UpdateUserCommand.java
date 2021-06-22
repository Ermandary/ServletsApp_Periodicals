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

public class UpdateUserCommand implements Command {

    private static final Logger log = LogManager.getLogger(UpdateUserCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("UpdateUserCommand starts");
        String address = Path.COMMAND_CLIENT_PROFILE;

        String methodName = req.getMethod();
        log.trace("input method ==> " + methodName);

        if (methodName.equals("GET")) {
            return Path.PAGE_UPDATE_USER;
        }

        String email = req.getParameter("email");
        log.trace("email ==> " + email);

        String firstName = req.getParameter("first_name");
        log.trace("firstName ==> " + firstName);

        String lastName = req.getParameter("last_name");
        log.trace("lastName ==> " + lastName);

        String password = req.getParameter("password");
        log.trace("password ==> " + password);

        String genderStr = req.getParameter("gender");

        if(email == null || email.isEmpty() || firstName ==null || firstName.isEmpty()
                || lastName==null || lastName.isEmpty() || password==null || password.isEmpty()
                || genderStr == null || genderStr.isEmpty()) {
            return Path.COMMAND_CLIENT_PROFILE;
        }

        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        log.trace("gender ==> " + gender);


        User user = (User) req.getSession().getAttribute("user");
        log.trace("user before update ==> " + user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setPassword(password);

        UserDao userDao = DaoFactory.createUserDao();

        userDao.updateUserWithoutBalance(user);

        user = userDao.findUserByID(user.getId());
        log.trace("user after update ==> " + user);
        req.getSession().setAttribute("user", user);

        log.debug("UpdateUserCommand finished");
        return address;
    }
}