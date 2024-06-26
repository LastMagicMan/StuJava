<%--
  Created by IntelliJ IDEA.
  User: long_
  Date: 2024/6/22
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看图书分类</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>图书管理系统</h1>
<div>
    <ul>
        <li><a href="<c:url value='/users/managementSystem' />">首页</a></li>
        <li><a href="<c:url value='/books/showBooks' />">查看图书</a></li>
        <li><a href="<c:url value='/categories/showCategories' />" class="active">查看分类</a></li>
    </ul>
</div>
<div>
    <h2>查看分类</h2>
    <form action="<c:url value='/categories/search' />" method="get">
        <input type="text" name="keyword" placeholder="输入关键字搜索">
        <input type="submit" value="搜索">
        <a href="<c:url value='/categories/addCategories' />">添加分类</a>
    </form>
    <div>
        <c:if test="${not empty categories}">
            <table>
                <tr>
                    <th>分类编号</th>
                    <th>分类名</th>
                    <th>分类详情</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.category_id}</td>
                        <td>${category.name}</td>
                        <td>${category.description}</td>
                        <td>
                            <a href="<c:url value='/categories/updateCategories/${category.category_id}' />">编辑</a>
                            <a href="<c:url value='/categories/deleteCategories/${category.category_id}' />" onclick="return confirm('确定删除吗？')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
