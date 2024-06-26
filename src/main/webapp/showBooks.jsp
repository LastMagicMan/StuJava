<%--
  Created by IntelliJ IDEA.
  User: long_
  Date: 2024/6/22
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看图书</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>图书管理系统</h1>
<div>
    <ul>
        <li><a href="<c:url value='/users/managementSystem' />">首页</a></li>
        <li><a href="<c:url value='/books/showBooks' />" class="active">查看图书</a></li>
        <li><a href="<c:url value='/categories/showCategories' />">查看分类</a></li>
    </ul>
</div>
<div>
    <h2>查看图书</h2>
    <form action="<c:url value='/books/search' />" method="get">
        <input type="text" name="keyword" placeholder="输入关键字搜索">
        <input type="submit" value="搜索">
        <a href="<c:url value='/books/addBooks' />">添加图书</a>
    </form>
    <div>
        <c:if test="${not empty books}">
            <table>
                <tr>
                    <th>编号</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>ISBN</th>
                    <th>出版年份</th>
                    <th>所属分类</th>
                    <th>价格</th>
                    <th>库存</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.book_id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.isbn}</td>
                        <td>${book.publish_year}</td>
                        <td>${book.category_name}</td>
                        <td>${book.price}</td>
                        <td>${book.stock}</td>
                        <td>
                            <a href="<c:url value='/books/updateBooks/${book.book_id}' />">编辑</a>
                            <a href="<c:url value='/books/deleteBooks/${book.book_id}' />" onclick="return confirm('确定删除吗？')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
