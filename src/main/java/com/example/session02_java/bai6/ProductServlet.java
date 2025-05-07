package com.example.session02_java.bai6;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ArrayList<Product> productList = new ArrayList<>();
    private int nextId = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            Product product = findProductById(id);
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/updateProduct.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("products", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Thêm sản phẩm
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            if (name != null && !name.isEmpty() && priceStr != null && !priceStr.isEmpty()) {
                double price = Double.parseDouble(priceStr);
                Product product = new Product(nextId++, name, price);
                productList.add(product);
            }
            response.sendRedirect("product");
        } else if ("update".equals(action)) {
            // Cập nhật sản phẩm
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            if (name != null && !name.isEmpty() && priceStr != null && !priceStr.isEmpty()) {
                double price = Double.parseDouble(priceStr);
                Product product = findProductById(id);
                if (product != null) {
                    product.setName(name);
                    product.setPrice(price);
                }
            }
            response.sendRedirect("product");
        } else if ("delete".equals(action)) {
            // Xóa sản phẩm
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = findProductById(id);
            if (product != null) {
                productList.remove(product);
            }
            response.sendRedirect("product");
        }
    }

    private Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}