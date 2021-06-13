<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание аккаунта</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body class="signup-body">

<header class="signup-header">
    <form class="signup-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="mainPage"/>
        <input type="submit" value="Catalog"/>
    </form>
</header>

<form action="controller" method="post">
    <input type="hidden" name="command" value="signup"/>

    <div class="signup-form">
        <h1>Sign Up</h1>
        <div class="signup-input">
            <p>Email</p>
            <input type="email" name="email" placeholder="Email" required/><br/>
            <p>Your name</p>
            <input type="text" name="first_name" placeholder="First name" required/><br/>
            <p>Your surname</p>
            <input type="text" name="last_name" placeholder="Last name" required/><br/>
            <p>Your gender</p>
            <select name="gender">
                <option selected value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
            <p>Password</p>
            <input type="password" name="password" placeholder="Password" required/><br/>
            <input type="submit" value="Sign Up"/>
        </div>
    </div>
</form>
</body>
</html>
