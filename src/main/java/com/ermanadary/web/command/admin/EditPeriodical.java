package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.dao.PeriodicalDao;
import com.ermanadary.entity.Periodical;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class EditPeriodical implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        System.out.println("EditPeriodical...");
        HttpSession session = req.getSession();
        Periodical periodical = null;

        String methodthodName = req.getMethod();
        System.out.println("input method ==> " + methodthodName);

        if (methodthodName.equals("GET")) {
            long periodicalId = Long.parseLong(req.getParameter("periodicalId"));
            periodical = DaoFactory.createPeriodicalDao().findPeriodicalById(periodicalId);
            session.setAttribute("periodical", periodical);
            session.setAttribute("periodicalId", periodicalId);
            return Path.PAGE_EDIT_PERIODICAL;
        }

//        System.out.println(session.getAttribute("periodicalId"));
//        long periodicalId = (Long)(session.getAttribute("periodicalId"));
//        Periodical periodical = DaoFactory.createPeriodicalDao().findPeriodicalById(periodicalId);
//
//        if (methodthodName.equals("GET")) {
//            session.setAttribute("periodical", periodical);
//            session.setAttribute("periodicalId", periodicalId);
//            return Path.PAGE_EDIT_PERIODICAL;
//        }

        System.out.println("изменяем издание");

        String periodicalName = req.getParameter("periodicalName");
        System.out.println("periodical name ==> " + periodicalName);

        String periodicalType = req.getParameter("periodicalType");
        System.out.println("periodical type ==> " + periodicalType);

        String publisher = req.getParameter("publisher");
        System.out.println("publisher ==> " + publisher);

        String frequency = req.getParameter("frequency");
        System.out.println("frequency ==> " + frequency);

        System.out.println(req.getParameter("periodicalPrice"));

        String priceStr = req.getParameter("periodicalPrice");

        BigDecimal price = new BigDecimal(req.getParameter("periodicalPrice"));


//        BigDecimal price = new BigDecimal("0.0");
//        if (priceStr.contains(".")) {
//            price = BigDecimal.valueOf(Double.parseDouble(req.getParameter("periodicalPrice")));
//        } else {
//            price = new BigDecimal(Integer.parseInt(req.getParameter("periodicalPrice")));
//        }

//        BigDecimal price = new BigDecimal(Integer.parseInt(req.getParameter("periodicalPrice")));
        System.out.println(price);

        String description = req.getParameter("periodicalDescription");
        System.out.println(description);

        periodical = new Periodical();
        periodical.setId((Long) session.getAttribute("periodicalId"));
        periodical.setName(periodicalName);
        periodical.setType(periodicalType);
        periodical.setPublisher(publisher);
        periodical.setFrequency(frequency);
        periodical.setPrice(price);
        periodical.setDescription(description);

        PeriodicalDao periodicalDao = DaoFactory.createPeriodicalDao();
        periodicalDao.updatePeriodical(periodical);

        return Path.COMMAND_MAIN_PAGE;
    }
}
