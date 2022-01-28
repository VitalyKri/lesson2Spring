<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create message</title>
</head>

<body>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Name: <form:input path="name"/>
    <br>
    Price: <form:textarea path="price"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>

</body>

</html>