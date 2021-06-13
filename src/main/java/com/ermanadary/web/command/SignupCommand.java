package com.ermanadary.web.command;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.dao.UserDao;
import com.ermanadary.entity.Gender;
import com.ermanadary.entity.User;
import com.ermanadary.web.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("SignUpCommand#execute");
        String address = "signup.jsp";

        String methodthodName = req.getMethod();
        System.out.println("input method ==> " + methodthodName);

        if (methodthodName.equals("GET")) {
            return Path.PAGE_SIGN_UP;
        }


        String email = req.getParameter("email");
        System.out.println("email ==> " + email);

        String firstName = req.getParameter("first_name");
        System.out.println("firstName ==> " + firstName);

        String lastName = req.getParameter("last_name");
        System.out.println("lastName ==> " + lastName);

        Gender gender = Gender.valueOf(req.getParameter("gender").toUpperCase());
        System.out.println("gender ==> " + gender);

        String password = req.getParameter("password");
        System.out.println("password ==> " + password);

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

        return address;
    }
}
