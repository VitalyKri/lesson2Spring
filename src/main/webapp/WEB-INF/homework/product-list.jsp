<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Message list</title>
</head>

<body>
<h1>Message list</h1>
<url>
  <c:forEach var="product" items="${products}">
      <c:url var="viewUrl" value="/cart/ +${product.id}"/>
      <li>
        <a href="${viewUrl}">View</a>
        <br>
        Id: ${product.id}
        <br>
        Name: ${product.name}
        <br>
        Price: ${product.price}
        <br>
      </li>
  </c:forEach>

</url>
<br>
<c:url var="createUrl" value="/cart/create"/>

<a href="${createUrl}">CREATE</a>

</body>

</html>