<%--
  Created by IntelliJ IDEA.
  User: long_
  Date: 2024/6/22
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>修改书籍信息</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>编辑图书</h2>
<form action="<c:url value='/books/updateBooks' />" method="post">
  <input type="hidden" id="book_id" name="book_id" value="${book.book_id}">
  <label for="title">书名:</label>
  <input type="text" id="title" name="title" value="${book.title}" required>
  <label for="author">作者:</label>
  <input type="text" id="author" name="author" value="${book.author}" required>
  <label for="isbn">ISBN:</label>
  <input type="text" id="isbn" name="isbn" value="${book.isbn}" required>
  <label for="publish_year">出版年份:</label>
  <input type="text" id="publish_year" name="publish_year" value="${book.publish_year}" required>
  <label for="category_name">分类:</label>
  <select id="category_name" name="category_name" required>
    <c:forEach var="category" items="${categories}">
      <option value="${category.name}" ${category.name == book.category_name ? 'selected' : ''}>${category.name}</option>
    </c:forEach>
  </select>
  <label for="price">价格:</label>
  <input type="text" id="price" name="price" value="${book.price}" required>
  <label for="stock">库存:</label>
  <input type="text" id="stock" name="stock" value="${book.stock}" required>
  <button type="submit">保存</button>
</form>
</body>
</html>
