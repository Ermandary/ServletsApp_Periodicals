<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>Client profile</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>


<header class="signup-header">
        <form class="profile-header" action="controller" method="get">
            <input type="hidden" name="command" value="updateUser"/>
            <input type="submit" value="Edit profile">
        </form>

        <form class="profile-header" action="controller" method="get">
            <input type="hidden" name="command" value="topUpBalance"/>
            <input type="submit" value="Top up balance">
        </form>

        <form class="profile-header" action="controller">
            <input type="hidden" name="command" value="mainPage"/>
            <input type="submit" value="Main page">
        </form>


        <form class="profile-header" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" value="Logout">
        </form>
</header>


<form action="controller" method="post">
    <input type="hidden" name="command" value="signup"/>

    <div class="client-profile-form">
        <h1>Your profile</h1>
        <div class="client-profile-input">
            <h3>${user.email}</h3>
            <h3>${user.firstName}</h3>
            <h3>${user.lastName}</h3>
            <h3>${user.balance}</h3>
        </div>
    </div>
</form>


<%--<h1>email: ${user.email}</h1></br>--%>
<%--<h1>Имя: ${user.firstName}</h1></br>--%>
<%--<h1>Фамилия: ${user.lastName}</h1></br>--%>
<%--<h1>Баланс: ${user.balance}</h1></br>--%>

<%--<form action="controller" method="get">--%>
<%--    <input type="hidden" name="command" value="updateUser"/>--%>
<%--    <input type="submit" value="edit profile">--%>
<%--</form>--%>

<%--<form action="controller" method="get">--%>
<%--    <input type="hidden" name="command" value="topUpBalance"/>--%>
<%--    <input type="submit" value="Пополнить счёт">--%>
<%--</form>--%>

<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="clientPage"/>--%>
<%--    <input type="submit" value="Main page">--%>
<%--</form>--%>


<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="logout"/>--%>
<%--    <input type="submit" value="Logout">--%>
<%--</form>--%>

</body>
</html>