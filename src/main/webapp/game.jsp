<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/7/2025
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Game Đoán Từ</title>
</head>
<body>
<h1>Game Đoán Từ</h1>

<div>
  <h2>Từ bí mật:</h2>
  <p>
    <%
      String secretWord = (String) request.getAttribute("secretWord");
      Set<String> guessedLetters = (Set<String>) session.getAttribute("guessedLetters");
      for (char c : secretWord.toCharArray()) {
        if (guessedLetters.contains(String.valueOf(c))) {
          response.getWriter().print(c + " ");
        } else {
          response.getWriter().print("_ ");
        }
      }
    %>
  </p>
</div>

<div>
  <h3>Số lần đoán còn lại: <%= request.getAttribute("attempts") %></h3>
  <form action="guess" method="post">
    <input type="text" name="guess" maxlength="1" required />
    <button type="submit">Đoán</button>
  </form>
</div>

<div>
  <%
    boolean isWin = (boolean) request.getAttribute("isWin");
    boolean isLost = (boolean) request.getAttribute("isLost");
    if (isWin) {
      response.getWriter().println("<h2>Bạn đã thắng! Từ bí mật là: " + request.getAttribute("secretWord") + "</h2>");
      response.getWriter().println("<a href='index.jsp'>Chơi lại</a>");
    } else if (isLost) {
      response.getWriter().println("<h2>Bạn đã thua! Từ bí mật là: " + request.getAttribute("secretWord") + "</h2>");
      response.getWriter().println("<a href='index.jsp'>Chơi lại</a>");
    }
  %>
</div>
</body>
</html>

