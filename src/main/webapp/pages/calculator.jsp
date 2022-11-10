<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 08.11.2022
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<s:form action="/calculator" method="post" modelAttribute="newOperation">
    <s:input path="num1" placeholder="Number 1"></s:input>
    <br>
    <s:errors path="num1"></s:errors>
    <br>
    <s:input path="num2" placeholder="Number 2"></s:input>
    <br>
    <s:errors path="num2"></s:errors>
    <br>
    <s:input path="operation" placeholder="Operation(write sum or diff or div or mul"></s:input>
    <br>
    <s:errors path="operation"></s:errors>
    <s:button>Submit</s:button>
</s:form>
<p>${resultOfOperation}</p>
<form action="/">
    <button type="submit">Return</button>
</form>

</body>
</html>
