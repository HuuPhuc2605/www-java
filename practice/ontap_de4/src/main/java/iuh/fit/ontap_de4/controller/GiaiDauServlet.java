package iuh.fit.ontap_de4.controller;

import iuh.fit.ontap_de4.dao.Impl.GiaiDauDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/giaidau")
public class GiaiDauServlet extends HttpServlet {
    private GiaiDauDAOImpl giaiDauDAO = new GiaiDauDAOImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action ="list";
        switch (action){
            case "list":
                req.setAttribute("list", giaiDauDAO.getAll());
                req.getRequestDispatcher("views/list.jsp").forward(req, resp);
                break;
        }
    }
}
