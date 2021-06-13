package com.ermanadary.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {

    //    private static final Logger log = Logger.getLogger(EncodingFilter.class);
    private String encoding;

    public void init(FilterConfig fConfig) throws ServletException {
//        log.debug("Filter initialization starts");
        System.out.println("Encoding filter start init");
        System.out.println("input encoding ==> " + fConfig.getInitParameter("encoding"));
        encoding = fConfig.getInitParameter("encoding");
        System.out.println("Encoding filter end init");

//        log.trace("Encoding from web.xml --> " + encoding);
//        log.debug("Filter initialization finished");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

//        log.debug("Filter starts");
        System.out.println("encoding Filter starts");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        log.trace("Request uri --> " + httpRequest.getRequestURI());
        System.out.println("request uti ==> " + httpRequest.getRequestURI());

        String requestEncoding = request.getCharacterEncoding();
        if (requestEncoding == null) {
            System.out.println("Request encoding = null, set encoding ==> " + encoding);
//            log.trace("Request encoding = null, set encoding --> " + encoding);
            request.setCharacterEncoding(encoding);
        } else {
            System.out.println("encoding not null Oo, input ==> " + encoding);
        }

//        log.debug("Filter finished");
        System.out.println("nice");
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("Filter encoding destroy");
//        log.debug("Filter destruction starts");
        // do nothing
//        log.debug("Filter destruction finished");
    }
}
