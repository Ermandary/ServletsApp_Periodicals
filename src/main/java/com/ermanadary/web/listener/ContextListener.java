package com.ermanadary.web.listener;

import com.ermanadary.dao.DBManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener starts...");

        ServletContext ctx = sce.getServletContext();

        initLogger(ctx);
        DBManager.getInstance();
        initCommandContainer();
        initI18N(ctx);

        System.out.println("ContextListener finished");
    }

    private void initLogger(ServletContext ctx) {
        System.out.println("init logger");

        String path = ctx.getRealPath("WEB-INF/app.log");
        System.out.println("path ==> " + path);
        System.setProperty("fileName", path);

        System.out.println("init logger finished");
    }

    private void initI18N(ServletContext context) {
        // obtain file name with locales descriptions
        String localesFileName = context.getInitParameter("locales");

        // obtain real path on server
        String localesFileRealPath = context.getRealPath(localesFileName);

        // load descriptions
        Properties locales = new Properties();
        try {
            locales.load(new FileInputStream(localesFileRealPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // save descriptions to servlet context
        context.setAttribute("locales", locales);
        locales.list(System.out);
    }

    private void initI18N2(ServletContext servletContext) {
        System.out.println("initI18N starts");

        String localesValue = servletContext.getInitParameter("locales");
        System.out.println("localesValue ==> " + localesValue);

        if (localesValue == null || localesValue.isEmpty()) {
            System.out.println("locales is empty");
        } else {
            List<String> locales = Arrays.asList(localesValue.split(" "));
            servletContext.setAttribute("locales", locales);
        }

        System.out.println("initI18n finished");
    }

    private void initCommandContainer() {
        System.out.println("Command container initialization started");

        try {
            Class.forName("com.ermanadary.web.command.CommandContainer");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Command container initialization finished");
    }
}
