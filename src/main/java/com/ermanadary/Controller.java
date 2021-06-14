package com.ermanadary;

import com.ermanadary.web.command.Command;
import com.ermanadary.web.command.CommandContainer;
import com.ermanadary.web.listener.ContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {

    private static final Logger log = LogManager.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Controller#doGet starts");

        String address = "error.jsp";
        String commandName = req.getParameter("command");
        log.trace("command ==> " + commandName);

        Command command = CommandContainer.getCommand(commandName);

        try {
            address = command.execute(req, resp);
            log.trace("address ==> " + address);
        } catch (DBException ex) {
            req.setAttribute("error", ex);
        }

        log.debug("Controller#doGet finished");
        req.getRequestDispatcher(address).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.debug("Controller#doGPost starts");

        String address = "error.jsp";
        String commandName = req.getParameter("command");
        log.trace("command ==> " + commandName);

        Command command = CommandContainer.getCommand(commandName);

        try {
            address = command.execute(req, resp);
            log.trace("address ==> " + address);
        } catch (DBException ex) {
            req.setAttribute("error", ex);
        }

        StringBuilder q = new StringBuilder("/periodicals");
        q.append(address);

        log.debug("Controller#doGPost finished");
        resp.sendRedirect(q.toString());
    }
}
