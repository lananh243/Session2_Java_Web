package com.example.session02_java.bai6;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");

        if (productList == null) {
            productList = new ArrayList<>();
            session.setAttribute("productList", productList);
        }

        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            Product product = findProductById(id, productList);
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
        HttpSession session = request.getSession();
        ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");

        if (productList == null) {
            productList = new ArrayList<>();
            session.setAttribute("productList", productList);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            if (name != null && !name.isEmpty() && priceStr != null && !priceStr.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceStr);
                    Product product = new Product(productList.size() + 1, name, price);
                    productList.add(product);
                    System.out.println("Thêm thành công: " + product);
                } catch (NumberFormatException e) {
                    e.printStackTrace();  // Xử lý ngoại lệ nếu giá không phải là một số hợp lệ
                }
            }
            response.sendRedirect("product");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            if (name != null && !name.isEmpty() && priceStr != null && !priceStr.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceStr);
                    Product product = findProductById(id, productList);
                    if (product != null) {
                        product.setName(name);
                        product.setPrice(price);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();  // Xử lý ngoại lệ nếu giá không phải là một số hợp lệ
                }
            }
            response.sendRedirect("product");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = findProductById(id, productList);
            if (product != null) {
                productList.remove(product);
            }
            response.sendRedirect("product");
        }
    }

    private Product findProductById(int id, ArrayList<Product> productList) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

