<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/18
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${depart.logname} ${depart.depname}</title>
</head>
<body>

<table>
    <tr>
        <td>部门编号</td>
        <td>${depart.logname}</td>
    </tr>
    <tr>
        <td>部门名称</td>
        <td>${depart.depname}</td>
    </tr>
    <tr>
        <td>部门级别</td>
        <td>${depart.level}</td>
    </tr>
    <tr>
        <td>所属社团</td>
        <td>${depart.assn.assnname}</td>
    </tr>
    <tr>
        <td>部门介绍</td>
        <td>${depart.intro}</td>
    </tr>
</table>
<%--部长团--%>
<table>
    <tr>
        <td>部长姓名</td>
        <td>部长性别</td>
        <td>部长联系方式</td>
        <td>部长职务</td>
    </tr>
    <c:forEach var="director" items="${depart.directors}">
        <tr>
            <td>${director.name}</td>
            <td>${director.sex}</td>
            <td>${director.phone}</td>
            <td>${director.level}</td>
        </tr>
    </c:forEach>
</table>
<%--部员--%>
<table>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>出生日期</td>
        <td>民族</td>
        <td>年级</td>
        <td>学院</td>
        <td>专业</td>
        <td>联系方式</td>
        <td>QQ号</td>
        <td>宿舍地址</td>
        <td>评价</td>
        <td>在职状态</td>
    </tr>
    <c:forEach var="member" items="${depart.members}">
        <tr>
            <td>${member.student.logname}</td>
            <td>${member.student.name}</td>
            <td>${member.student.sex}</td>
            <td>${member.student.birthday}</td>
            <td>${member.student.nation}</td>
            <td>${member.student.grade}</td>
            <td>${member.student.department}</td>
            <td>${member.student.major}</td>
            <td>${member.student.phone}</td>
            <td>${member.student.qqnumber}</td>
            <td>${member.student.dorm}</td>
            <td>${member.appraise}</td>
            <td>${member.status}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
