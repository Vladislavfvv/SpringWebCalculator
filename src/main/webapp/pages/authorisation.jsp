<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 06.11.2022
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorisation</title>
</head>
<body>
<h1>Enter your personal data</h1>
<s:form action="/authorisation" method="post" modelAttribute="authorisationUser">
    <s:input path="email" placeholder = "Email"></s:input>
    <s:input path="password" placeholder = "Password"></s:input>
    <s:button>Submit</s:button>
</s:form>
<form action="/">
    <button type="submit">Return</button>
</form>

</body>
</html>
