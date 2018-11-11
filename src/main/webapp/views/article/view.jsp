<%--@elvariable id="article" type="com.qduam.modules.article.entity.Article"--%>
<%--
  Created by IntelliJ IDEA.
  User: lilinzhen
  Date: 2018/11/11
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.title}</title>
</head>
<body>

<table>
    <tr>
        <td>${article.title}</td>
    </tr>
    <tr>
        <td>${article.time}</td>
    </tr>
    <tr>
        <td>${article.user.name}</td>
    </tr>
    <tr>
        <td>${article.content}</td>
    </tr>
</table>
</body>
</html>
