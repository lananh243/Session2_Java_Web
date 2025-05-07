<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/6/2025
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhập Thông Tin Người Dùng</title>
</head>
<body>
    <h1>Form Nhập Thông Tin</h1>
    <form action="/bt2" method="post">
        <div>
            <label for="username">Họ và tên: </label>
            <input type="text" name="username" id="username">
        </div>
        <br><br>
        <div>
            <label for="age">Tuổi: </label>
            <input type="number" name="age" id="age">
        </div>
        <br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
