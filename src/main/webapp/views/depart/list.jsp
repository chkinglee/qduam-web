<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/18
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门列表</title>
</head>
<body>
<c:out value="${msg}"/>
<table>
    <c:forEach items="${departList}" var="depart">
        <tr>
            <td><a href="${pageContext.request.contextPath}/depart/get/${depart.id}">${depart.logname}</a></td>
            <td>${depart.depname}</td>
            <td>${depart.intro}</td>
            <td>${depart.level}</td>
            <td>${depart.assn.assnname}</td>
            <td><a href="${pageContext.request.contextPath}/depart/edit/${depart.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/depart/del/${depart.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
