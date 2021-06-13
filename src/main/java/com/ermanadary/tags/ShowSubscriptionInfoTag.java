package com.ermanadary.tags;

import com.ermanadary.entity.SubscriptionInfo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ShowSubscriptionInfoTag extends TagSupport {

    //    private Periodical periodical;
    private SubscriptionInfo subscriptionInfo;

//    public void setPeriodical(Periodical periodical) {
//        this.periodical = periodical;
//    }


    public void setSubscriptionInfo(SubscriptionInfo subscriptionInfo) {
        this.subscriptionInfo = subscriptionInfo;
    }

    @Override
    public int doStartTag() throws JspException {
        System.out.println("MyTag starts");

        JspWriter out = pageContext.getOut();
        try {
            out.print("<div class=\"container2 mtb2\">");
            out.print("<table class=\"table2\">");
            out.print("<tr>");
            out.print("<th>Name</th>");
            out.print("<th>Type</th>");
            out.print("<th>Frequency</th>");
            out.print("<th>Active from</th>");
            out.print("<th>Active to</th>");
            out.print("</tr>");

            out.print("<tr>");
            out.print(String.format("<td>%s</td>", subscriptionInfo.getPeriodicalName()));
            out.print(String.format("<td>%s</td>", subscriptionInfo.getPeriodicalType()));
            out.print(String.format("<td>%s</td>", subscriptionInfo.getFrequency()));
            out.print(String.format("<td>%s</td>", subscriptionInfo.getStartDate()));
            out.print(String.format("<td>%s</td>", subscriptionInfo.getEndDate()));
            out.print("</tr>");
            out.print("</table>");
            out.print("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("periodical ==> " + periodical);

        return TagSupport.SKIP_BODY;
    }
}

//<c:forEach var="num" items="${subscriptionsInfo}">
//    <div class="container2 mtb2">
//        <table class="table2">
//            <tr>
//                <th>Name</th>
//                <th>Type</th>
//                <th>Frequency</th>
//                <th>Active from</th>
//                <th>Active to</th>
//            </tr>
//            <tr>
//                <td>${num.periodicalName}</td>
//                <td>${num.periodicalType}</td>
//                <td>${num.frequency}</td>
//                <td>${num.startDate}</td>
//                <td>${num.endDate}</td>
//            </tr>
//        </table>
//    </div>
//</c:forEach>
