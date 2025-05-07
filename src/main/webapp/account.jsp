<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/6/2025
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Ký Tài Khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

<div class="bg-white p-8 rounded-lg shadow-md w-96">
    <h2 class="text-2xl font-bold mb-6">Đăng Ký Tài Khoản</h2>
    <form action="account" method="get">
        <div class="mb-4">
            <label for="username" class="block text-sm font-medium text-gray-700">Tên đăng nhập <span class="text-red-500">*</span></label>
            <input type="text" id="username" name="username" class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:ring focus:ring-blue-300" />
        </div>

        <div class="mb-4">
            <label for="password" class="block text-sm font-medium text-gray-700">Mật khẩu <span class="text-red-500">*</span></label>
            <input type="password" id="password" name="password" class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:ring focus:ring-blue-300" />
        </div>

        <div class="mb-4">
            <label for="fullname" class="block text-sm font-medium text-gray-700">Họ tên <span class="text-red-500">*</span></label>
            <input type="text" id="fullname" name="fullname" class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:ring focus:ring-blue-300" />
        </div>

        <div class="mb-4">
            <label for="age" class="block text-sm font-medium text-gray-700">Tuổi</label>
            <input type="number" id="age" name="age" class="mt-1 w-full border border-gray-300 rounded-md p-2 focus:ring focus:ring-blue-300" />
        </div>

        <div class="mb-4">
            <label for="address" class="block text-sm font-medium text-gray-700">Địa chỉ</label>
            <input type="text" id="address" name="address" class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:ring focus:ring-blue-300" />
        </div>

        <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600">Đăng Ký</button>
    </form>
</div>

</body>
</html>
