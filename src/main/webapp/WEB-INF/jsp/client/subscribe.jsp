<%--
  Created by IntelliJ IDEA.
  User: Neftyanik
  Date: 02.06.2021
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscribe</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1>Name: ${periodical.name}</h1></body></br>
<h1>Type: ${periodical.type}</h1></br>
<h1>Publisher: ${periodical.publisher}</h1></br>
<h1>Frequency: ${periodical.frequency}</h1></br>
<h1>Month price: ${periodical.price}</h1></br>
<h1>Description: ${periodical.description}</h1></br>

<form action="controller" method="post">
    <input type="hidden" name="command" value="payment"/><br/>

        <p><select name="subscriptionType">
            <option selected value="ONE_MONTH">One month</option>
            <option value="THREE_MONTHS">Three months</option>
            <option value="SIX_MONTHS">Six months</option>
            <option value="ONE_YEAR">One year</option>
        </select></p>
        <p><input type="submit" value="Continue"></p>
</form>

</body>
</html>
