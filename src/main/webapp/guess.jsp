<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/7/2025
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đoán Từ</title></head>
<body>
    <h2>Game Đoán Từ</h2>

    <p>Từ bí mật: <strong><%= request.getAttribute("maskedWord") %></strong></p>
    <p>Lượt đoán còn lại: <%= request.getAttribute("attemptsLeft") %></p>

    <%
      Boolean win = (Boolean) request.getAttribute("win");
      Boolean lose = (Boolean) request.getAttribute("lose");
      String word = (String) request.getAttribute("word");

      if (win != null && win) {
    %>
    <h3 style="color:green">🎉 Bạn đã đoán đúng!</h3>
    <form action="guess" method="get">
      <button>Chơi lại</button>
    </form>
    <%
    } else if (lose != null && lose) {
    %>
    <h3 style="color:red">💀 Bạn đã thua! Từ là: <%= word %></h3>
    <form action="guess" method="get">
      <button>Chơi lại</button>
    </form>
    <%
    } else {
    %>
    <form action="guess" method="post">
      <input type="text" name="guess" maxlength="1" required />
      <button>Đoán</button>
    </form>
    <%
      }
    %>
</body>
</html>



