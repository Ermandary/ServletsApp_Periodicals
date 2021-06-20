package com.ermanadary.tags;

import com.ermanadary.dao.impl.mysql.MySqlUserDao;
import com.ermanadary.entity.SubscriptionInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ShowSubscriptionInfoTag extends TagSupport {

    private static final Logger log = LogManager.getLogger(MySqlUserDao.class);

    private SubscriptionInfo subscriptionInfo;

    public void setSubscriptionInfo(SubscriptionInfo subscriptionInfo) {
        this.subscriptionInfo = subscriptionInfo;
    }

    @Override
    public int doStartTag() {
        log.debug("ShowSubscriptionInfoTag starts");


        JspWriter out = pageContext.getOut();
        try {
            out.print("<tr>");
                out.print(String.format("<td>%s</td>", subscriptionInfo.getPeriodicalName()));
                out.print(String.format("<td>%s</td>", subscriptionInfo.getPeriodicalType()));
                out.print(String.format("<td>%s</td>", subscriptionInfo.getFrequency()));
                out.print(String.format("<td>%s</td>", subscriptionInfo.getStartDate()));
                out.print(String.format("<td>%s</td>", subscriptionInfo.getEndDate()));
            out.print("</tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.debug("ShowSubscriptionInfoTag finished");
        return TagSupport.SKIP_BODY;
    }
}