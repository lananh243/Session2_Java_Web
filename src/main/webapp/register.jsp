<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/7/2025
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhập thông tin cá nhân</title>
</head>
<body>
    <h1>Form Nhập thông tin cá nhân</h1>
    <form action="bt4" method="post">
        <div>
            <label for="username">Tên </label>
            <input type="text" name="username" id="username">
        </div>
        <br><br>
        <div>
            <label for="email">Email </label>
            <input type="email" name="email" id="email">
        </div>
        <br><br>
        <button type="submit">Gửi</button>
    </form>

</body>
</html>
