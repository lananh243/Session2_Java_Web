package com.example.session02_java;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LifecycleServlet", value = "/bt1")
public class LifecycleServlet extends HttpServlet {


    public void init() {
        System.out.println("LifecycleServlet đã được khởi tạo");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Vòng đời của Servlet</title></head>");
        out.println("<body>");
        out.println("<h2>Vòng đời của Servlet</h2>");
        out.println("<p><b>1. init()</b>: Phương thức này được gọi một lần khi Servlet được tạo lần đầu tiên.</p>");
        out.println("<p><b>2. service()</b>: Phương thức này được gọi mỗi khi có yêu cầu từ client. Nó xử lý yêu cầu và trả về phản hồi.</p>");
        out.println("<p><b>3. destroy()</b>: Phương thức này được gọi khi Servlet bị hủy, có thể là khi container web dừng hoạt động hoặc Servlet bị xóa khỏi container.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
        System.out.println("LifecycleServlet đã bị hủy");
    }
}