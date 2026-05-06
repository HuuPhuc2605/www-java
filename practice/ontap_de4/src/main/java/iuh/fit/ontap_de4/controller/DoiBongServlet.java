package iuh.fit.ontap_de4.controller;

import iuh.fit.ontap_de4.dao.Impl.DoiBongDaoImpl;
import iuh.fit.ontap_de4.dao.Impl.GiaiDauDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/doibong")
public class DoiBongServlet extends HttpServlet {
    private DoiBongDaoImpl doiBongDao = new DoiBongDaoImpl();
    private GiaiDauDAOImpl giaiDauDAO = new GiaiDauDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        req.setAttribute("giaidauList", giaiDauDAO.getAll());
        switch (action) {
            case "list":
                req.setAttribute("list", doiBongDao.getAllDB());
                req.getRequestDispatcher("views/list.jsp").forward(req, resp);
                break;
            case "detail":
                int ma = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("detail", doiBongDao.getBYID(ma));
                req.getRequestDispatcher("views/detail.jsp").forward(req, resp);
                break;
            case "search":
                String name = req.getParameter("ten");
                req.setAttribute("list", doiBongDao.getByTen(name));
                req.getRequestDispatcher("views/list.jsp").forward(req, resp);
                break;
            case "byGD":
                int ma1 = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("list", doiBongDao.getByGiai(ma1));
                req.getRequestDispatcher("views/list.jsp").forward(req, resp);
                break;
            case "edit":
                int ma2 = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("e", doiBongDao.getBYID(ma2));
                req.getRequestDispatcher("views/update.jsp").forward(req, resp);
                break;

        }
    }
}
