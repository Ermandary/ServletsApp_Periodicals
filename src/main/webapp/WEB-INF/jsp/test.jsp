<%--
  Created by IntelliJ IDEA.
  User: Neftyanik
  Date: 19.06.2021
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>Login</title>
    <link href="final.css" rel="stylesheet" type="text/css">
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
    </div>

    <div class="content">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="login"/>

            <div class="login-form">
                <h1>Sign In</h1>
                <div class="login-input">
                    <input type="email" name="email" placeholder="email" required/><br/>
                    <input type="password" name="password" placeholder="password" required/><br/>
                    <input type="submit" value="Sign In"/>
                </div>
                <a href="signup.jsp" class="signup">Sign Up</a>
            </div>
        </form>
    </div>

    <div class="footer">
        <div class="footer-info">
            <h4>2021 Alexander Ipatov</h4>
        </div>
    </div>

</div>
</body>
</html>
