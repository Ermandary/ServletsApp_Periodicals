package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.dao.PeriodicalDao;
import com.ermanadary.entity.Periodical;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class AddPeriodicalCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("AddPeriodicalCommand");

        String methodthodName = req.getMethod();
        System.out.println("input method ==> " + methodthodName);

        if (methodthodName.equals("GET")) {
            return Path.PAGE_ADD_PERIODICAL;
        }

        System.out.println("добавляем издание");

        String periodicalName = req.getParameter("periodicalName");
        System.out.println("periodical name ==> " + periodicalName);

        String periodicalType = req.getParameter("periodicalType");
        System.out.println("periodical type ==> " + periodicalType);

        String publisher = req.getParameter("publisher");
        System.out.println("publisher ==> " + publisher);

        String frequency = req.getParameter("frequency");
        System.out.println("frequency ==> " + frequency);

        BigDecimal price = new BigDecimal(Integer.parseInt(req.getParameter("periodicalPrice")));
        System.out.println(price);

        String description = req.getParameter("periodicalDescription");
        System.out.println(description);

        Periodical periodical = new Periodical();
        periodical.setName(periodicalName);
        periodical.setType(periodicalType);
        periodical.setPublisher(publisher);
        periodical.setFrequency(frequency);
        periodical.setPrice(price);
        periodical.setDescription(description);

        PeriodicalDao periodicalDao = DaoFactory.createPeriodicalDao();
        periodicalDao.addPeriodical(periodical);

        return Path.COMMAND_MAIN_PAGE;
    }
}
