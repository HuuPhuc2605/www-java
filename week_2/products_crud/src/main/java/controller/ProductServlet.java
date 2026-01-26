package controller;

import dao.ProductDAO;
import model.Product;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ProductServlet extends HttpServlet {

    private ProductDAO dao;

    public void init() {
        dao = new ProductDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getServletPath();

        switch (action) {
            case "/new":
                req.getRequestDispatcher("product-form.jsp").forward(req, resp);
                break;

            case "/insert":
                insert(req, resp);
                break;

            case "/delete":
                delete(req, resp);
                break;

            case "/edit":
                showEdit(req, resp);
                break;

            case "/update":
                update(req, resp);
                break;

            default:
                list(req, resp);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> list = dao.selectAllProducts();
        req.setAttribute("listProduct", list);
        req.getRequestDispatcher("product-list.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        dao.insertProduct(new Product(
                req.getParameter("name"),
                Double.parseDouble(req.getParameter("price")),
                req.getParameter("urlImage")
        ));
        resp.sendRedirect("list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        dao.deleteProduct(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("list");
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Product p = dao.selectProduct(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("product", p);
        req.getRequestDispatcher("product-form.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        dao.updateProduct(new Product(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                Double.parseDouble(req.getParameter("price")),
                req.getParameter("urlImage")
        ));
        resp.sendRedirect("list");
    }
}
