package com.ermanadary.web.listener;

import com.ermanadary.dao.DBManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener starts...");
        initLogger(sce);
        DBManager.getInstance();
        initCommandContainer();

        System.out.println("ContextListener finished");
    }

    private void initLogger(ServletContextEvent sce){
        System.out.println("init logger");
        ServletContext ctx = sce.getServletContext();
        String path = ctx.getRealPath("WEB-INF/app.log");
        System.out.println("path ==> " + path);

        System.setProperty("fileName", path);

        Logger log = LogManager.getLogger(ContextListener.class);
        log.info("info");
        System.out.println("init logger finished");

    }

    private void initI18N(ServletContext servletContext) {

        List<String> locales = Arrays.asList(servletContext.getInitParameter("locales").split(" "));
        servletContext.setAttribute("locales", locales);

        if(locales.isEmpty()) {

        }



//        log.debug("I18N subsystem initialization started");

        String localesValue = servletContext.getInitParameter("locales");
        if (localesValue == null || localesValue.isEmpty()) {
//            log.warn("'locales' init parameter is empty, the default encoding will be used");
        } else {
//            List<String> locales = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(localesValue);
            while (st.hasMoreTokens()) {
                String localeName = st.nextToken();
                locales.add(localeName);
            }

//            log.debug("Application attribute set: locales --> " + locales);
            servletContext.setAttribute("locales", locales);
        }

//        log.debug("I18N subsystem initialization finished");
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
