package com.ermanadary.web.command;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.Periodical;
import com.ermanadary.entity.Role;
import com.ermanadary.web.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

public class MainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("main page command...");
        HttpSession session = req.getSession();
        String address = Path.PAGE_MAIN;
        List<Periodical> periodicals;

        String isSearch = req.getParameter("isSearch");
        if (isSearch != null) {
            periodicals = DaoFactory.createPeriodicalDao().findPeriodicalsByName(req.getParameter("search"));
        } else {
            String sortName = req.getParameter("sortBy");
            periodicals = DaoFactory.createPeriodicalDao().findAllPeriodicals();

            if (sortName == null || sortName.isEmpty() || sortName.equals("type")) {
                sortByType(periodicals);
            } else if (sortName.equals("name")) {
                sortByName(periodicals);
            } else if (sortName.equals("price")) {
                sortByPrice(periodicals);
            }
        }
        session.setAttribute("periodicals", periodicals);

        Role userRole = (Role) session.getAttribute("userRole");

        if (userRole == null) {
            return address;
        } else if (userRole == Role.ADMIN) {
            address = Path.COMMAND_ADMIN_PAGE;
        } else if (userRole == Role.CLIENT) {
            address = Path.COMMAND_CLIENT_PAGE;
        }
        return address;
    }

    private List<Periodical> sortByType(List<Periodical> periodicals) {
        periodicals.sort(Comparator.comparing(Periodical::getType));
        return periodicals;
    }

    private List<Periodical> sortByName(List<Periodical> periodicals) {
        periodicals.sort(Comparator.comparing(Periodical::getName));
        return periodicals;
    }

    private List<Periodical> sortByPrice(List<Periodical> periodicals) {
        periodicals.sort(Comparator.comparing(Periodical::getPrice));
        return periodicals;
    }
}
