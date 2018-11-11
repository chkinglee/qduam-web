<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/11
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章列表</title>
</head>
<body>
<c:out value="${msg}"/>
<table>
    <c:forEach items="${articleList}" var="article">
        <tr>
            <td><a href="${pageContext.request.contextPath}/article/get/${article.id}">${article.title}</a></td>
            <td>${article.time}</td>
            <td>${article.user.name}</td>
            <td><a href="${pageContext.request.contextPath}/article/edit/${article.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/article/del/${article.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
