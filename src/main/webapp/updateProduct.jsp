<%@ page import="com.example.session02_java.bai6.Product" %><%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/7/2025
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.session02_java.bai6.Product" %>
<html>
<head>
    <title>Cập Nhật Sản Phẩm</title>
</head>
<body>
<h1>Cập Nhật Sản Phẩm</h1>

<%
    Product product = (Product) request.getAttribute("product");
    if (product != null) {
%>
<form action="product" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= product.getId() %>">
    <label>Tên:</label>
    <input type="text" name="name" value="<%= product.getName() %>" required>
    <br>
    <label>Giá:</label>
    <input type="number" name="price" value="<%= product.getPrice() %>" required>
    <br>
    <input type="submit" value="Cập Nhật">
</form>
<%
} else {
%>
<p>Sản phẩm không tìm thấy.</p>
<%
    }
%>

<a href="product">Quay lại danh sách sản phẩm</a>
</body>
</html>

