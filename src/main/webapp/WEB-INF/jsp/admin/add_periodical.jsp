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

<form action="controller" method="post">
    <input type="hidden" name="command" value="addPeriodical"/><br/>

    <h3>Name</h3><input type="text" name="periodicalName" required/><br/>
    <h3>Type</h3>
    <p><select name="periodicalType">
        <option selected value="Comic">Comic</option>
        <option value="Magazine">Magazine</option>
        <option value="Newspaper">Newspaper</option>
    </select></p>
    <h3>Publisher</h3><input type="text" name="publisher" required>
    <h3>Frequency</h3>
    <p><select name="frequency">
        <option selected value="Daily">Daily</option>
        <option value="Weekly">Weekly</option>
        <option value="Monthly">Monthly</option>
    </select></p>
    <h3>Month price, $</h3><input type="number" name="periodicalPrice" required>
    <h3>Description</h3><textarea name="periodicalDescription" required></textarea></br>

    <input type="submit" value="add periodical"/>
</form>

</body>
</html>
