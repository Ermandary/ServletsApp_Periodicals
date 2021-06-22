package com.ermanadary.web.command;

import com.ermanadary.exceptions.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException;
}
