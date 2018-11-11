<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/11
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页面</title>
</head>
<body>

<%--@elvariable id="article" type="com.qduam.modules.article.entity.Article"--%>
<form:form modelAttribute="article" action="article/save">
    <table>
        <tr>
            <td>标题</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>时间</td>
            <td><input id="time" type="date"/></td>
        </tr>
        <tr>
            <td>一级板块</td>
            <td><form:input path="sectionA"/></td>
        </tr>
        <tr>
            <td>二级版块</td>
            <td><form:input path="sectionB"/></td>
        </tr>
        <tr>
            <td>作者</td>
            <td>${sessionScope.user.name}</td>
            <input hidden id="user.id" value="${sessionScope.user.id}">
        </tr>
        <tr>
            <td>内容</td>
            <td><form:textarea path="content"/></td>
        </tr>

    </table>

</form:form>
</body>
</html>
