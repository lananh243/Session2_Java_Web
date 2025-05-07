package com.example.session02_java;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ForwardServlet", value = "/bt3")
public class ForwardServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");


        request.setAttribute("name", name);
        request.setAttribute("price", price);
        request.setAttribute("quantity", quantity);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/display.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("forward.jsp");
    }

}