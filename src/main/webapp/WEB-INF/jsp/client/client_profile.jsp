<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <title>Client profile</title>
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
        <div class="header-section inner-menu">
            <ul>
                <li>
                    <h2>${user.firstName} &#9660</h2>
                    <ul>
                        <li>
                            <form action="controller">
                                <input type="hidden" name="command" value="showSubscriptions"/>
                                <input type="submit" value="<fmt:message key='subscriptions'/>">
                            </form>
                        </li>
                        <li>
                            <form class="profile-header" action="controller" method="get">
                                <input type="hidden" name="command" value="topUpBalance"/>
                                <input type="submit" value="<fmt:message key='top_up_balance'/>">
                            </form>
                        </li>
                        <li>
                            <form action="controller">
                                <input type="hidden" name="command" value="logout"/>
                                <input type="submit" value="<fmt:message key='logout'/>">
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div class="content">
        <div class="client-info">
            <table class="client-table">
                <tr>
                    <th class="profile-name" colspan="2"><fmt:message key='profile'/></th>
                </tr>
                <tr>
                    <th><fmt:message key='email'/></th>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <th><fmt:message key='name'/></th>
                    <td>${user.firstName}</td>
                </tr>
                <tr>
                    <th><fmt:message key='login_page_surname'/></th>
                    <td>${user.lastName}</td>
                </tr>
                <tr>
                    <th><fmt:message key='balance'/></th>
                    <td>${user.balance}</td>
                </tr>
                <tr>
                    <th colspan="2">
                        <form class="edit-profile" action="controller" method="get">
                            <input type="hidden" name="command" value="updateUser"/>
                            <input type="submit" value="<fmt:message key='edit_profile'/>">
                        </form>
                    </th>
                </tr>
            </table>
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