package com.ermanadary;

import com.ermanadary.web.command.Command;
import com.ermanadary.web.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Controller#doGet");

        String address = "error.jsp";
        String commandName = req.getParameter("command");
        System.out.println("command ==> " + commandName);

        Command command = CommandContainer.getCommand(commandName);

        try {
            address = command.execute(req, resp);
            System.out.println("address ==> " + address);
        } catch (DBException ex) {
            req.setAttribute("error", ex);
        }

        req.getRequestDispatcher(address).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Controller#doGPost");

        String address = "error.jsp";
        String commandName = req.getParameter("command");
        System.out.println("command ==> " + commandName);

        Command command = CommandContainer.getCommand(commandName);

        try {
            address = command.execute(req, resp);
            System.out.println("address ==> " + address);
        } catch (DBException ex) {
            req.setAttribute("error", ex);
        }

        StringBuilder q = new StringBuilder("/periodicals");
                q.append(address);
        System.out.println(q);

        resp.sendRedirect(q.toString());
    }
}
