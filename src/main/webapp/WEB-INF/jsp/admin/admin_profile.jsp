<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>

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


<h1>Email: ${user.email}</h1></br>
<h1>First name: ${user.firstName}</h1></br>
<h1>Last name: ${user.lastName}</h1></br>


<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="adminPage"/>--%>
<%--    <input type="submit" value="Main page">--%>
<%--</form>--%>


<%--<form action="controller">--%>
<%--    <input type="hidden" name="command" value="logout"/>--%>
<%--    <input type="submit" value="Logout">--%>
<%--</form>--%>

</html>

