package com.ermanadary.web.command;

import com.ermanadary.exceptions.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.entity.Periodical;
import com.ermanadary.entity.Role;
import com.ermanadary.web.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

public class MainPageCommand implements Command {

    private static final Logger log = LogManager.getLogger(MainPageCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("MainPageCommand starts");

        HttpSession session = req.getSession();
        String address = Path.PAGE_ERROR;
        List<Periodical> periodicals;

        String isSearch = req.getParameter("isSearch");
        if (isSearch != null) {
            periodicals = DaoFactory.createPeriodicalDao().findPeriodicalsByName(req.getParameter("search"));
        } else {
            String sortName = req.getParameter("sortBy");
            periodicals = DaoFactory.createPeriodicalDao().findAllPeriodicals();

            if (sortName == null || sortName.isEmpty() || sortName.equals("type")) {
                sortByType(periodicals);
                session.setAttribute("sortName", "type");
            } else if (sortName.equals("name")) {
                sortByName(periodicals);
                session.setAttribute("sortName", "name");
            } else if (sortName.equals("price")) {
                sortByPrice(periodicals);
                session.setAttribute("sortName", "price");
            }
        }
        session.setAttribute("periodicals", periodicals);

        Role userRole = (Role) session.getAttribute("userRole");
        log.trace("userRole ==> " + userRole);

        if (userRole == null) {
            address = Path.PAGE_MAIN;
        } else if (userRole == Role.ADMIN) {
            address = Path.COMMAND_ADMIN_PAGE;
        } else if (userRole == Role.CLIENT) {
            address = Path.COMMAND_CLIENT_PAGE;
        }

        log.trace("address ==> " + address);
        log.debug("MainPageCommand finished");
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
