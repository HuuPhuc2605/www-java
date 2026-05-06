package iuh.fit.ontap_de2.servlet;

import iuh.fit.ontap_de2.dao.impl.HangSXDAOImpl;
import iuh.fit.ontap_de2.model.HangSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/hang")
public class HangSXServlet extends HttpServlet {
    private HangSXDAOImpl hangSXDAO = new HangSXDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HangSX> list = hangSXDAO.getAllHangSX();
        request.setAttribute("hangList", list);
        request.getRequestDispatcher("views/list.jsp").forward(request,response);
    }
}
