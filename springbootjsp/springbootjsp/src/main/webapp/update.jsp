<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/7/30
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/user/update" method="post">

        <input type="text" name="id" value="${user.id}"><br>
        <input type="text" name="name" value="${user.name}"><br>
        <input type="submit" value="提交"><br>

    </form>
</body>
</html>
