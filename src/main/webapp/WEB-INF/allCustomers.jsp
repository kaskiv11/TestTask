<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2022
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>all Customers</title>
</head>
<body>

<c:forEach var="customer" items="${customers}">
    <tr>
        <td>${customer.id}"/></td>
        <td>${customer.fullName}"/></td>
        <td>${customer.phone}"/></td>
        <td>${customer.isActive}"/></td>
    </tr>
</c:forEach>
</body>
</html>
