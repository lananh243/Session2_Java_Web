package com.example.session02_java;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterAccountServlet", value = "/account")
public class RegisterAccountServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String age = request.getParameter("age");
        String address = request.getParameter("address");


        PrintWriter out = response.getWriter();
        if (username == null || password == null || fullname == null || age == null || address == null) {
            out.println("Đăng kí thất bại");
        } else {
            out.println("Đăng kí thành công");
            out.println("Username: "+username);
            out.println("Password: "+password);
            out.println("Họ và tên: "+fullname);
            out.println("Tuổi: "+age);
            out.println("Địa chỉ: "+address);
        }
    }

    public void destroy() {
    }
}