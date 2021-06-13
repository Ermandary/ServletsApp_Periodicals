<%--
  Created by IntelliJ IDEA.
  User: Neftyanik
  Date: 04.06.2021
  Time: 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<form action="controller" method="post">
<input type="hidden" name="command" value="topUpBalance"/><br/>

<h3>Amount of money, $</h3><input type="number" name="amount" required/><br/>
<h3>Сard number</h3><input type="text" name="cardNumber" value="4145 3312 4315 9843" required/><br/>
<h3>Validity</h3><input type="text" name="validity" value="12/21" required/><br/>

<h3>CVV2</h3><input type="text" name="CVV2" value="221" required/><br/>
<input type="submit" value="Top up balance"/>
</form>

</body>
</html>
