<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 08.11.2022
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation history for ${sessionScope.currentUser.firstName}</title>
</head>
<body>
<h1>Operations for ${sessionScope.currentUser.firstName}:</h1>
<s:forEach items="${operationList}" var="operation">
    <ul>
        <li>
            ${operation}
        </li>
    </ul>
</s:forEach>

<form action="/">
    <button type="submit">Return</button>
</form>
</body>
</html>
