<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="mylib" uri="http://com.ermandary/mylib" %>

<html>
<head>
    <title>Subscriptions</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<form action="controller">
    <input type="hidden" name="command" value="mainPage"/>
    <input type="submit" value="Main page">
</form>


<c:forEach var="num" items="${subscriptionsInfo}">
    
    <mylib:showSubscriptionInfo subscriptionInfo="${num}"/>
<%--    <div class="container2 mtb2">--%>
<%--        <table class="table2">--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <th>Type</th>--%>
<%--                <th>Frequency</th>--%>
<%--                <th>Active from</th>--%>
<%--                <th>Active to</th>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>${num.periodicalName}</td>--%>
<%--                <td>${num.periodicalType}</td>--%>
<%--                <td>${num.frequency}</td>--%>
<%--                <td>${num.startDate}</td>--%>
<%--                <td>${num.endDate}</td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </div>--%>
</c:forEach>

</body>
</html>
