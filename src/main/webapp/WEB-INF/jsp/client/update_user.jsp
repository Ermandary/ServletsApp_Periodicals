<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>

<form action="controller" method="post">
    <input type="hidden" name="command" value="updateUser"/><br/>
    <input type="hidden" name="email" value="${user.email}"/><br/>

    <h3>First name</h3><input type="text" name="first_name" value="${user.firstName}" required/><br/>
    <h3>Last name</h3><input type="text" name="last_name" value="${user.lastName}" required/><br/>

    <p> <select name="gender">
        <option selected value="MALE">Male</option>
        <option value="FEMALE">Female</option>
    </select></p>
    <h3>Password</h3><input type="password" name="password" value="${user.password}" required/><br/>
    <input type="submit" value="Save"/>

</form>

</body>
</html>