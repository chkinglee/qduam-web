<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/18
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${assn.logname} ${assn.assnname}</title>
</head>
<body>

<table>
    <tr>
        <td>社团编号</td>
        <td>${assn.logname}</td>
    </tr>
    <tr>
        <td>社团名称</td>
        <td>${assn.assnname}</td>
    </tr>
    <tr>
        <td>社团负责人</td>
        <td>${assn.director}</td>
    </tr>
    <tr>
        <td>负责人联系方式</td>
        <td>${assn.phone}</td>
    </tr>
    <tr>
        <td>社团类型</td>
        <td>${assn.level}</td>
    </tr>
</table>
<table>
    <tr>
        <td>部门编号</td>
        <td>部门名称</td>
        <td>部门级别</td>
        <td>部门介绍</td>
    </tr>
    <c:forEach var="depart" items="${assn.departs}">
        <tr>
            <td>${depart.logname}</td>
            <td>${depart.depname}</td>
            <td>${depart.level}</td>
            <td>${depart.intro}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>