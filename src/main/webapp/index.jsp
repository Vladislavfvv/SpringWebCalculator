<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

<s:if test="${sessionScope.currentUser == null}">
    <h2>Sign up to calculator</h2>
    <a href="/registration">Sign up</a>
    <br>
    <a href="/authorisation">Sign in</a>
</s:if>

<s:if test="${sessionScope.currentUser != null}">
    <h2>Select operation</h2>
    <h1>Hi, ${currentUser.firstName}</h1>
    <a href="/calculator">Calculator</a>
    <br>
    <a href="/history">Calculation history</a>
    <br>
    <a href="/logout">Sign out</a>
</s:if>
</body>
</html>
