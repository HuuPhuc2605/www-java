package iuh.fit.ontap_de2.servlet;

import iuh.fit.ontap_de2.dao.HangSXDAO;
import iuh.fit.ontap_de2.dao.impl.DienThoaiDAOImpl;
import iuh.fit.ontap_de2.dao.impl.HangSXDAOImpl;
import iuh.fit.ontap_de2.model.DienThoai;
import iuh.fit.ontap_de2.model.HangSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dienthoai")
public class DienThoaiServlet extends HttpServlet {
    private DienThoaiDAOImpl dienThoaiDAO = new DienThoaiDAOImpl();
    private HangSXDAOImpl hangSXDAO = new HangSXDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";
        request.setAttribute("hangList", hangSXDAO.getAllHangSX());
        switch (action) {
            case "list":
                request.setAttribute("list", dienThoaiDAO.getAllDienThoai());
                request.getRequestDispatcher("views/list.jsp").forward(request, response);
                break;
            case "detail":
                int maDT = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("detail", dienThoaiDAO.getByID(maDT));
                request.getRequestDispatcher("views/detail.jsp").forward(request, response);
                break;
            case "search":
                //getParameter và tên bên jsp input phải trùng nhau
                String tenDT = request.getParameter("name");
                request.setAttribute("list", dienThoaiDAO.getByName(tenDT));
                request.getRequestDispatcher("views/list.jsp").forward(request, response);
                break;
            case "byHang":
                int maHang = Integer.parseInt(request.getParameter("maHang"));
                request.setAttribute("list", dienThoaiDAO.getByHang(maHang));
                request.getRequestDispatcher("views/list.jsp").forward(request, response);
                break;
            case "edit":
                int editID = Integer.parseInt(request.getParameter("maDT"));
                request.setAttribute("edit", dienThoaiDAO.getByID(editID));
                request.setAttribute("hList", hangSXDAO.getAllHangSX());
                request.getRequestDispatcher("views/update.jsp").forward(request, response);
                break;
            case "add":
                request.setAttribute("hangList", hangSXDAO.getAllHangSX());
                request.getRequestDispatcher("views/insert.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            DienThoai dienThoai = new DienThoai();
            dienThoai.setMaDT(Integer.parseInt(request.getParameter("maDT")));
            dienThoai.setTenDT(request.getParameter("tenDT"));
            dienThoai.setGiaBan(Double.parseDouble(request.getParameter("giaBan")));
            dienThoai.setAnhDT(request.getParameter("anhDT"));
            dienThoai.setBoNho(request.getParameter("boNho"));
            HangSX hangSX = new HangSX();
            hangSX.setMaHang(Integer.parseInt(request.getParameter("maHang")));
            dienThoai.setMaHang(hangSX);
            dienThoaiDAO.update(dienThoai);
            response.sendRedirect("dienthoai?action=list");

        }else if ("insert".equals(action)){
            DienThoai dienThoai = new DienThoai();
            dienThoai.setTenDT(request.getParameter("tenDT"));
            dienThoai.setGiaBan(Double.parseDouble(request.getParameter("giaBan")));
            dienThoai.setAnhDT(request.getParameter("anhDT"));
            dienThoai.setBoNho(request.getParameter("boNho"));
            HangSX hangSX = new HangSX();
            hangSX.setMaHang(Integer.parseInt(request.getParameter("maHang")));
            dienThoai.setMaHang(hangSX);
            dienThoaiDAO.add(dienThoai);
            response.sendRedirect("dienthoai?action=list");

        }else if("delete".equals(action)){
            dienThoaiDAO.delete(Integer.parseInt(request.getParameter("maDT")));
            response.sendRedirect("dienthoai?action=list");

        }

    }
}
