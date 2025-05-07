
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/6/2025
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.session02_java.bai6.Product" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script>
        function confirmDelete(id) {
            if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này?")) {
                document.getElementById("deleteForm" + id).submit();
            }
        }
    </script>
</head>
<body>
<form action="product" method="post">
    <div class="flex justify-center items-center">
        <div class="w-2/5 h-[150px] border p-4 bg-white mt-20">
            <h2 class="text-center font-semibold">Thêm Sản Phẩm</h2>
            <label for="name">Tên: </label>
            <input type="text" name="name" id="name" required class="border border-gray-300 rounded p-1 w-full mb-2">
            <br>
            <label for="price">Giá: </label>
            <input type="number" name="price" id="price" required class="border border-gray-300 rounded p-1 w-full mb-2">
            <br>
            <input type="submit" name="action" value="Thêm sản phẩm" class="bg-blue-500 text-white rounded p-1 w-full">
        </div>
    </div>
</form>

<table class="w-2/5 h-[150px] p-4 bg-white m-auto mt-20">
    <thead>
    <tr>
        <td>ID</td>
        <td>Tên</td>
        <td>Giá</td>
        <td>Hành động</td>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
        if (products != null) {
            for (Product product : products) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td>
            <a href="product?id=<%= product.getId() %>">Sửa</a>
            <form id="deleteForm<%= product.getId() %>" action="product" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= product.getId() %>">
                <input type="button" value="Xóa" onclick="confirmDelete(<%= product.getId() %>)">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">Không có sản phẩm nào.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

