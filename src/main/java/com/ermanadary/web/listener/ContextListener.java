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

    private static final Logger log = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("ContextListener starts...");
        DBManager dbManager = DBManager.getInstance();
        initCommandContainer();

//        ServletContext servletContext = sce.getServletContext();
//        initI18N(servletContext);




//        List<String> locales = Arrays.asList(servletContext.getInitParameter("locales").split(" "));
//        servletContext.setAttribute("locales", locales);
//        System.out.println(locales);
        log.debug("ContextListener finished");
    }

//    public void contextInitialized(ServletContextEvent event) {
//		log("Servlet context initialization starts");
//
//		ServletContext servletContext = event.getServletContext();
//		initLog4J(servletContext);
//		initCommandContainer();
//		initI18N(servletContext);
//
//		log("Servlet context initialization finished");
//	}


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
        log.debug("Command container initialization started");

        // initialize commands container
        // just load class to JVM
        try {
            Class.forName("com.ermanadary.web.command.CommandContainer");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        log.debug("Command container initialization finished");
    }
}
