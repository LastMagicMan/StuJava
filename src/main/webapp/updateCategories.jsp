<%--
  Created by IntelliJ IDEA.
  User: long_
  Date: 2024/6/22
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>修改图书分类</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>编辑分类</h2>
<form action="<c:url value='/categories/updateCategories' />" method="post">
    <input type="hidden" id="category_id" name="category_id" value="${category.category_id}">
    <label for="name">分类名:</label>
    <input type="text" id="name" name="name" value="${category.name}" required>
    <br>
    <label for="description">分类详情:</label>
    <input type="text" id="description" name="description" value="${category.description}" required>
    <br>
    <input type="submit" value="保存">
</form>
</body>
</html>
