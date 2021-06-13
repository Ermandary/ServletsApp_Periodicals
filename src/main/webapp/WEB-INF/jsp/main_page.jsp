<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="mylib" uri="http://com.ermandary/mylib" %>--%>
<html>
<head>
    <title>Periodicals</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body class="mainPage-body">

<header class="signup-header">
    <form class="login-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="login"/>
        <input type="submit" value="Login"/>
    </form>
    <form class="signup-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="signup"/>
        <input type="submit" value="Sign Up"/>
    </form>

    <form class="signup-catalog" action="controller" method="get">
        <input type="hidden" name="command" value="mainPage"/><br/>

<%--        <select name="roleName">--%>
<%--            <c:forEach items="${roleNames}" var="role">--%>
<%--                <option value="${role}" ${role == selectedRole ? 'selected' : ''}>${role}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>


        <p><select name="sortBy">
            <option selected value="type">Type</option>
            <option value="name">Name</option>
            <option value="price">Price</option>
        </select></p>
        <p><input type="submit" value="Sort"></p>
    </form>
    <form class="signup-catalog" action="controller" method="post">
        <input type="hidden" name="command" value="mainPage"/>
        <input type="hidden" name="isSearch" value="true"/>

        <input type="search" name="search" required>
        <input type="submit" value="Search"/>
    </form>

</header>




<c:forEach var="num" items="${periodicals}">
    
<%--    <mylib:showPeriodical periodical="${num}"/>--%>

    <div class="container mtb">
        <table class="table">
            <tr>
                <th class="name" colspan="2">${num.name}</th>
            </tr>
            <tr>
                <th class="other">Type</th>
                <td>${num.type}</td>
            </tr>
            <tr>
                <th class="other">Publisher</th>
                <td>${num.publisher}</td>
            </tr>
            <tr>
                <th class="other">Frequency</th>
                <td>${num.frequency}</td>
            </tr>
            <tr>
                <th class="other">Month price</th>
                <td class="price">${num.price}</td>
            </tr>
            <tr>
                <th colspan="2">
                    <form class="sub1" action="controller">
                        <input type="hidden" name="command" value="login"/>
                        <p><input type="submit" value="Subscribe"></p>
                    </form>
                </th>
            </tr>

        </table>
    </div>
</c:forEach>

</body>
</html>
