<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Periodicals</title>
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
                <li>
                    <form class="header-item header-button" action="changeLocale.jsp" method="get">
                        <fmt:message key="settings_jsp.label.set_locale"/>:
                        <select name="locale">
                            <c:forEach items="${applicationScope.locales}" var="locale">
                                <c:set var="selected" value="${locale.key == currentLocale ? 'selected' : '' }"/>
                                <option value="${locale.key}" ${selected}>${locale.value}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="<fmt:message key='main_page.save'/>">
                    </form>
                </li>
                <li>
                    <form class="header-item header-button" action="controller" method="get">
                        <input type="hidden" name="command" value="mainPage"/><br/>

                        <p><select name="sortBy">
                            <option selected value="type">Type</option>
                            <option value="name">Name</option>
                            <option value="price">Price</option>
                        </select></p>
                        <p><input type="submit" value="<fmt:message key='main_page.sort'/>"></p>
                    </form>
                </li>
                <li>
                    <form class="header-item header-button" action="controller" method="post">
                        <input type="hidden" name="command" value="mainPage"/>
                        <input type="hidden" name="isSearch" value="true"/>

                        <input type="search" name="search" required>
                        <input type="submit" value="<fmt:message key='main_page.search'/>"/>
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
        <c:forEach var="num" items="${periodicals}">

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
                                <p><input type="submit" value="<fmt:message key='main_page.subscribe'/>"></p>
                            </form>
                        </th>
                    </tr>

                </table>
            </div>
        </c:forEach>
    </div>

    <div class="footer">
        <div class="footer-info">
            <h4>2021 Alexander Ipatov</h4>
        </div>
    </div>
</div>
</body>
</html>











<nav class="menu">
    <ul>
        <li>
            <form class="header-item header-logo" action="controller" method="get">
                <input type="hidden" name="command" value="mainPage"/>
                <input type="submit" value="Periodicals"/>
            </form>
        </li>
        <li>
            <form class="header-item header-button" action="controller">
                <input type="hidden" name="command" value="showSubscriptions"/>
                <input type="submit" value="Subscriptions">
            </form>
        </li>

        <li>
            <form class="header-item header-button" action="controller">
                <input type="hidden" name="command" value="showSubscriptions"/>
                <input type="submit" value="Profile &#9660">
            </form>
            <ul>
                <li>
                    <form class="header-item header-button" action="controller">
                        <input type="hidden" name="command" value="showSubscriptions"/>
                        <input type="submit" value="Профиль">
                    </form>
                </li>
                <li>
                    <form class="header-item header-button" action="controller">
                        <input type="hidden" name="command" value="showSubscriptions"/>
                        <input type="submit" value="Настройки">
                    </form>
                </li>
            </ul>
        </li>
    </ul>
</nav>
























