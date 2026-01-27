package iuh.fit.se.productscrud.servlet;

import iuh.fit.se.productscrud.dao.ProductDAO;
import iuh.fit.se.productscrud.model.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Admin
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            // /list (mặc định)
            listProducts(req, resp);
            return;
        }

        switch (action) {
            case "new" -> showNewForm(req, resp);
            case "edit" -> showEditForm(req, resp);
            case "delete" -> deleteProduct(req, resp);
            default -> listProducts(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            resp.sendRedirect("products");
            return;
        }

        switch (action) {
            case "insert" -> insertProduct(req, resp);
            case "update" -> updateProduct(req, resp);
            default -> resp.sendRedirect("products");
        }
    }



    // /list
    private void listProducts(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("products", productDAO.selectAllProducts());
        req.getRequestDispatcher("product-list.jsp").forward(req, resp);
    }

    // /new
    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("product-form.jsp").forward(req, resp);
    }

    // /edit
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDAO.findById(id);
        req.setAttribute("product", product);

        req.getRequestDispatcher("product-form.jsp").forward(req, resp);
    }

    // /insert
    private void insertProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String urlImage = req.getParameter("url_image");

        Product product = new Product(null, name, price, urlImage);
        productDAO.insertProduct(product);

        resp.sendRedirect("products");
    }

    // /update
    private void updateProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String urlImage = req.getParameter("url_image");

        Product product = new Product(id, name, price, urlImage);
        productDAO.updateProduct(product);

        resp.sendRedirect("products");
    }

    // /delete
    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.deleteProduct(id);

        resp.sendRedirect("products");
    }
}
