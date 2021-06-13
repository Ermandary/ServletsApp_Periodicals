<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<header class="signup-header">

    <form class="clientProfile-header" action="controller">
        <input type="hidden" name="command" value="mainPage"/>
        <input type="submit" value="Main page">
    </form>

    <form class="showSubscriptions-header" action="controller">
        <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="Logout">
    </form>

</header>

<c:forEach var="num" items="${users}">
    <div class="container2 mtb2">
        <table class="table2">
            <tr>
                <th>Id</th>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Gender</th>
                <th>Balance</th>
                <th>Status</th>
            </tr>
            <tr>
                <td>${num.id}</td>
                <td>${num.email}</td>
                <td>${num.firstName}</td>
                <td>${num.lastName}</td>
                <td>${num.gender}</td>
                <td>${num.balance}</td>
                <td>${num.status}</td>
            </tr>
            <tr>
                <th colspan="7">
                    <form class="users-block" action="controller" method="get">
                        <input type="hidden" name="command" value="block"/>
                        <input type="hidden" name="userId" value="${num.id}"/>
                        <p><input type="submit" value="block"></p>
                    </form>
                    <form class="users-unblock" action="controller" method="get">
                        <input type="hidden" name="command" value="unblock"/>
                        <input type="hidden" name="userId" value="${num.id}"/>
                        <p><input type="submit" value="unblock"></p>
                    </form>
                </th>
            </tr>
        </table>
    </div>
</c:forEach>

</body>
</html>
