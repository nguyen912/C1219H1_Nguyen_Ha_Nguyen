<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/19/2020
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach var="abc" items="${customers}">
        <tr>
            <td><c:out value="${abc.getName()}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

