<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client page</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<header class="signup-header">
    <form class="clientProfile-header" action="controller">
        <input type="hidden" name="command" value="clientProfile"/>
        <input type="submit" value="View profile">
    </form>

    <form class="showSubscriptions-header" action="controller">
        <input type="hidden" name="command" value="showSubscriptions"/>
        <input type="submit" value="Subscriptions">
    </form>

    <form class="logout-header" action="controller">
        <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="Logout">
    </form>
        <form class="signup-catalog" action="controller" method="get">
            <input type="hidden" name="command" value="mainPage"/><br/>

            <p><select name="sortBy">
                <option selected value="type">Type</option>
                <option value="name">Name</option>
                <option value="price">Price</option>
            </select></p>
            <p><input type="submit" value="Sort"></p>
        </form>
        <form class="signup-catalog" action="controller" method="post">
            <input type="hidden" name="command" value="mainPage"/>
            <input type="hidden" name="isSearch" value="true"/>

            <input type="search" name="search" required>
            <input type="submit" value="Search"/>
        </form>
</header>


<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="clientProfile"/>--%>
<%--    <input type="submit" value="view profile">--%>
<%--</form>--%>

<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="showSubscriptions"/>--%>
<%--    <input type="submit" value="subscriptions">--%>
<%--</form>--%>

<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="logout"/>--%>
<%--    <input type="submit" value="Logout">--%>
<%--</form>--%>

<c:forEach var="num" items="${periodicals}">
    <div class="container mtb">
        <table class="table">
            <tr>
                <th class="name" colspan="2">${num.name}</th>
            </tr>
            <tr>
                <th class="other">Type</th>
                <td>${num.type}</td>
            </tr>
            <tr>
                <th class="other">Publisher</th>
                <td>${num.publisher}</td>
            </tr>
            <tr>
                <th class="other">Frequency</th>
                <td>${num.frequency}</td>
            </tr>
            <tr>
                <th class="other">Month price</th>
                <td class="price">${num.price}</td>
            </tr>
            <tr>
                <th colspan="2">
                        <%--                    <form class="sub1" action="controller">--%>
                        <%--                        <input type="hidden" name="command" value="login"/>--%>
                        <%--                        <p><input type="submit" value="Subscribe"></p>--%>
                        <%--                    </form>--%>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="subscribe"/>
                        <input type="hidden" name="periodicalId" value="${num.id}"/>
                        <p><input type="submit" value="Subscribe"></p>
                    </form>
                </th>
            </tr>

        </table>
    </div>
</c:forEach>


<%--<c:forEach var="num" items="${periodicals}">--%>
<%--    <p>${num}</p>--%>
<%--    <form action="controller" method="get">--%>
<%--        <input type="hidden" name="command" value="subscribe"/>--%>
<%--        <input type="hidden" name="periodicalId" value="${num.id}"/>--%>
<%--        <p><input type="submit" value="Subscribe"></p>--%>
<%--    </form>--%>
<%--</c:forEach>--%>

</body>
</html>