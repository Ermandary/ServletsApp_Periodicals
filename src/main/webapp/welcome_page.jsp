<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<header class="signup-header">
    <form class="signup-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="mainPage"/>
        <input type="submit" value="Catalog"/>
    </form>
    <form class="login-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="login"/>
        <input type="submit" value="Login"/>
    </form>
    <form class="signup-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="signup"/>
        <input type="submit" value="Sign Up"/>
    </form>
</header>

<h2>Periodicals</h2>
<h1>The system contains a list of periodicals that are grouped by type. User can subscribe to one or more periodicals.</h1>
<h1>The user sign up at the system and has personal profile, where he can see his subscriptions.</h1>
<h1>Unregistered user cannot subscribe.</h1>
<h1>The user has a personal account that he can replenish. Money from the credit balance is deducted during the subscription</h1>
<h1>The Administrator has the right to block/unblock users, as well as add/remove/edit subscriptions.</h1>


</body>
</html>
