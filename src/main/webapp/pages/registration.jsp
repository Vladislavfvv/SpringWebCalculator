<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 06.11.2022
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<s:form action="/registration" method="post" modelAttribute="newUser">
    <s:input path="firstName" placeholder="First Name"></s:input>
    <s:input path="secondName" placeholder="Second Name"></s:input>
    <s:input path="email" placeholder="Email"></s:input>
    <s:input path="password" placeholder="Password"></s:input>
    <s:button>Submit</s:button>
</s:form>
<form action="/">
    <button type="submit">Return</button>
</form>
</body>
</html>
