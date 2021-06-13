<%--
  Created by IntelliJ IDEA.
  User: Neftyanik
  Date: 02.06.2021
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1>Payer: ${user.firstName} ${user.lastName}</h1></body></br>
<h1>Periodical name: ${periodical.name}</h1></body></br>
<h1>Frequency: ${periodical.frequency}</h1></br>
<h1>Subscription period: ${subscriptionPeriod}</h1></br>
<h1>Month price: ${periodical.price}</h1></br>
<%--<h1>и дескрипшион намбер: ${subscriptionPeriod.number}</h1></br>--%>
<h1>Total price: ${periodical.price * subscriptionPeriod.number}</h1></br>
<h1>Your balance: ${user.balance}</h1></br>

<form action="controller" method="get">
    <input type="hidden" name="command" value="topUpBalance"/>
    <input type="submit" value="Top up balance">
</form>

<form action="controller" method="get">
    <input type="hidden" name="command" value="paymentForm"/>
    <input type="submit" value="Pay">
</form>

</body>
</html>
