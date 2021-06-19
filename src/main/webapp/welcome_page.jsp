<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Welcome page</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="wrapper">

    <div class="header">
        <div class="header-section">
            <ul>
                <li>
                    <form class="header-item header-logo" action="controller" method="get">
                        <input type="hidden" name="command" value="mainPage"/>
                        <input type="submit" value="Periodicals"/>
                    </form>
                </li>
            </ul>
        </div>
        <div class="header-section">
            <ul>
                <li>
                    <form class="header-item header-button" action="controller" method="get">
                        <input type="hidden" name="command" value="login"/>
                        <input type="submit" value="<fmt:message key='login'/>"/>
                    </form>
                </li>
                <li>
                    <form class="header-item header-button" action="controller" method="get">
                        <input type="hidden" name="command" value="signup"/>
                        <input type="submit" value="<fmt:message key='signup'/>"/>
                    </form>
                </li>
            </ul>
        </div>
    </div>

    <div class="content">
        <div class="system-info">
            <h1>Periodicals</h1>
            <h2>The system contains a list of periodicals that are grouped by type. User can subscribe to one or more
                periodicals.</h2>
            <h2>The user sign up at the system and has personal profile, where he can see his subscriptions.
                Unregistered user cannot subscribe.</h2>
            <h2>The user has a personal account that he can replenish. Money from the credit balance is deducted during
                the subscription.</h2>
            <h2>The Administrator has the right to block/unblock users, as well as add/remove/edit
                subscriptions.</h2>
        </div>
    </div>

    <div class="footer">
        <div class="footer-info">
            <h4>2021 Alexander Ipatov</h4>
        </div>
    </div>
</div>
</body>
</html>
