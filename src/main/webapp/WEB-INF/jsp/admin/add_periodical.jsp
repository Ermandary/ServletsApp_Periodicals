<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Add periodical</title>
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
                                <input type="hidden" name="command" value="adminProfile"/>
                                <input type="submit" value="<fmt:message key='view_profile'/>">
                            </form>
                        </li>
                        <li>
                            <form action="controller">
                                <input type="hidden" name="command" value="showUsers"/>
                                <input type="submit" value="<fmt:message key='users'/>">
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

        <form action="controller" method="post">
            <div class="client-info">
                <table class="client-table">
                    <tr>
                        <th class="profile-name" colspan="2"><fmt:message key='add_periodical'/></th>
                    </tr>
                    <tr>
                        <th><fmt:message key='name'/></th>
                        <td>
                            <input type="text" name="periodicalName" required/>
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key='type'/></th>
                        <td>
                            <select name="periodicalType">
                                <option selected value="Comic">Comic</option>
                                <option value="Magazine">Magazine</option>
                                <option value="Newspaper">Newspaper</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key='publisher'/></th>
                        <td>
                            <input type="text" name="publisher" required>
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key='frequency'/></th>
                        <td>
                            <select name="frequency">
                                <option selected value="Daily">Daily</option>
                                <option value="Weekly">Weekly</option>
                                <option value="Monthly">Monthly</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="periodical-input1">
                        <th><fmt:message key='month_price'/></th>
                        <td>
                            <input type="number" name="periodicalPrice" required>
                        </td>
                    </tr>
                    <tr class="periodical-input1">
                        <th><fmt:message key='description'/></th>
                        <td>
                            <textarea name="periodicalDescription" required></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <input type="submit" value="<fmt:message key='add_periodical'/>"/>
                        </th>
                    </tr>
                </table>
            </div>
            <input type="hidden" name="command" value="addPeriodical"/><br/>
            <input type="hidden" name="email" value="${user.email}"/><br/>
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

<form action="controller" method="post">
    <input type="hidden" name="command" value="editPeriodical"/><br/>

    <h3>Name</h3><input type="text" name="periodicalName" value="${periodical.name}" required/><br/>
    <h3>Type</h3>
    <p><select name="periodicalType">
        <option selected value="Comic">Comic</option>
        <option value="Magazine">Magazine</option>
        <option value="Newspaper">Newspaper</option>
    </select></p>
    <h3>Publisher</h3><input type="text" name="publisher" value="${periodical.publisher}" required>
    <h3>Frequency</h3>
    <p><select name="frequency">
        <option selected value="Daily">Daily</option>
        <option value="Weekly">Weekly</option>
        <option value="Monthly">Monthly</option>
    </select></p>
    <h3>Month price, $</h3><input type="number" name="periodicalPrice" value="${periodical.price}" required>
    <h3>Description</h3><textarea name="periodicalDescription" required>${periodical.description}</textarea></br>

    <input type="submit" value="save"/>
</form>
