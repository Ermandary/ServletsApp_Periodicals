package com.ermanadary.web.command.admin;

import com.ermanadary.DBException;
import com.ermanadary.dao.DaoFactory;
import com.ermanadary.dao.PeriodicalDao;
import com.ermanadary.entity.Periodical;
import com.ermanadary.web.Path;
import com.ermanadary.web.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class AddPeriodicalCommand implements Command {

    private static final Logger log = LogManager.getLogger(AddPeriodicalCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("AddPeriodicalCommand starts");

        String methodName = req.getMethod();
        log.trace("input method ==> " + methodName);

        if (methodName.equals("GET")) {
            return Path.PAGE_ADD_PERIODICAL;
        }

        String periodicalName = req.getParameter("periodicalName");
        log.trace("periodical name ==> " + periodicalName);

        String periodicalType = req.getParameter("periodicalType");
        log.trace("periodical type ==> " + periodicalType);

        String publisher = req.getParameter("publisher");
        log.trace("publisher ==> " + publisher);

        String frequency = req.getParameter("frequency");
        log.trace("frequency ==> " + frequency);

        BigDecimal price = new BigDecimal(Integer.parseInt(req.getParameter("periodicalPrice")));
        log.trace("price ==> " + price);

        String description = req.getParameter("periodicalDescription");
        log.trace("description ==> " + description);

        Periodical periodical = new Periodical();
        periodical.setName(periodicalName);
        periodical.setType(periodicalType);
        periodical.setPublisher(publisher);
        periodical.setFrequency(frequency);
        periodical.setPrice(price);
        periodical.setDescription(description);

        PeriodicalDao periodicalDao = DaoFactory.createPeriodicalDao();
        periodicalDao.addPeriodical(periodical);

        log.debug("AddPeriodicalCommand finished");
        return Path.COMMAND_MAIN_PAGE;
    }
}
