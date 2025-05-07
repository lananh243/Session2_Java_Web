package com.example.session02_java;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserRegistrationServlet", value = "/bt5")
public class UserRegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("registerUser.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username =  request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/infoUser.jsp");
        dispatcher.forward(request, response);
    }
    public void destroy() {
    }
}