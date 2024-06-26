<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>请登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>登录</h2>
<form action="${pageContext.request.contextPath}/users/login" method="post">
    <label for="username">用户名:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="登录">
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
