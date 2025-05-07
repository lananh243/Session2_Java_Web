<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/6/2025
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhập thông tin sản phẩm</title>
</head>
<body>
    <h1>Nhập thông tin sản phẩm</h1>
    <form action="bt3" method="post">
        <div>
            <label for="name">Tên sản phẩm </label>
            <input type="text" name="name" id="name">
        </div>
        <br><br>
        <div>
            <label for="price">Giá </label>
            <input type="number" name="price" id="price">
        </div>
        <br><br>
        <div>
            <label for="quantity">Số lượng </label>
            <input type="number" name="quantity" id="quantity">
        </div>
        <br><br>
        <button type="submit">Gửi</button>
    </form>
</body>
</html>
