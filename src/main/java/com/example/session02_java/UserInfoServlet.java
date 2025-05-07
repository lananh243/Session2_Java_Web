package com.example.session02_java;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserInfoServlet", value = "/bt2")
public class UserInfoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");

       request.setAttribute("username", username);
       request.setAttribute("age", age);

        request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("form.jsp");
    }
}