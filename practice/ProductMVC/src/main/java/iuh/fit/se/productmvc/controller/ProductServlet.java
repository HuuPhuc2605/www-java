package iuh.fit.se.productmvc.controller;

import iuh.fit.se.productmvc.dao.ProductDAO;
import iuh.fit.se.productmvc.model.Product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO dao;

    public void init() {
        dao = new ProductDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        try {
            if (action == null) {
                List<Product> list = dao.getAllProducts();
                // gưir dữ liệu sang jsp
                req.setAttribute("productList", list);
                // chuyển sang trang
                req.getRequestDispatcher("views/product-list.jsp").forward(req, resp);
            } else if (action.equals("delete")) {
                dao.deleteProduct(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("products");
            } else if (action.equals("edit")) {
                Product p = dao.getProductById(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("product", p);
                req.getRequestDispatcher("views/product-form.jsp").forward(req, resp);
            } else if (action.equals("new")) {
                req.getRequestDispatcher("views/product-form.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String id = req.getParameter("id");

            Product p = new Product(
                    id == null || id.isEmpty() ? 0 : Integer.parseInt(id),
                    req.getParameter("name"),
                    Double.parseDouble(req.getParameter("price")),
                    Integer.parseInt(req.getParameter("unitInStock")),
                    req.getParameter("urlImage")
            );

            if (id == null || id.isEmpty()) {
                dao.insertProduct(p);
            } else {
                dao.updateProduct(p);
            }

            resp.sendRedirect("products");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}