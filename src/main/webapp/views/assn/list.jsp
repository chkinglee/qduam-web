<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/18
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>社团列表</title>
</head>
<body>
<c:out value="${msg}"/>
<table>
    <c:forEach items="${assnList}" var="assn">
        <tr>
            <td><a href="${pageContext.request.contextPath}/assn/get/${assn.id}">${assn.logname}</a></td>
            <td>${assn.assnname}</td>
            <td>${assn.director}</td>
            <td>${assn.phone}</td>
            <td>${assn.level}</td>
            <td><a href="${pageContext.request.contextPath}/assn/edit/${assn.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/assn/del/${assn.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
