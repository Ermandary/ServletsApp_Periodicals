<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body class="login-body">

<header class="signup-header">
    <form class="signup-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="mainPage"/>
        <input type="submit" value="Catalog"/>
    </form>
</header>

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

</body>
</html>
