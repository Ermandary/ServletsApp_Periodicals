<%--
  Created by IntelliJ IDEA.
  User: Neftyanik
  Date: 04.06.2021
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are blocked</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<h2>Your account is blocked. Contact the administrator</h2>

<form action="controller" method="get">
    <input type="hidden" name="command" value="login"/>
    <input type="submit" value="login"/>
</form>

</body>
</html>
