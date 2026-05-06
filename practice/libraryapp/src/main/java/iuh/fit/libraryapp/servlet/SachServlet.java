package iuh.fit.libraryapp.servlet;

import iuh.fit.libraryapp.dao.impl.SachDAOImpl;
import iuh.fit.libraryapp.dao.impl.TheLoaiDAOImpl;
import iuh.fit.libraryapp.model.Sach;
import iuh.fit.libraryapp.model.TheLoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sach")
public class SachServlet extends HttpServlet {
    private final SachDAOImpl sachDAO = new SachDAOImpl();
    private TheLoaiDAOImpl theLoaiDAO = new TheLoaiDAOImpl();
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";
        request.setAttribute("theloaiList", theLoaiDAO.getAll());
        switch (action){
            case "list":
                request.setAttribute("list", sachDAO.getAll());
                request.getRequestDispatcher("views/list.jsp").forward(request, response);
                break;
            case "detail":
                //id phải trùng với id cần truyền qua trong jsp
                int id = Integer.parseInt(request.getParameter("id"));
                //detail ngay attribute phải giống như bên jsp
                request.setAttribute("detail", sachDAO.getByID(id));
                request.getRequestDispatcher("views/detail.jsp").forward(request, response);
                break;
            case "search":
                String name = request.getParameter("name");
                request.setAttribute("list", sachDAO.getByName(name));
                request.getRequestDispatcher("views/list.jsp").forward(request, response);
                break;
            case "byTL":
                int maTL = Integer.parseInt(request.getParameter("maTL"));
                request.setAttribute("list", sachDAO.getByTheLoai(maTL));
                request.getRequestDispatcher("views/list.jsp").forward(request, response);
                break;
            case "edit":
                int editId = Integer.parseInt(request.getParameter("maSach"));
                request.setAttribute("s", sachDAO.getByID(editId));
                request.setAttribute("tlList", theLoaiDAO.getAll());
                request.getRequestDispatcher("views/update.jsp").forward(request, response);
                break;

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if("update".equals(action)){
            Sach sach = new Sach();
            sach.setMaSach(Integer.parseInt(request.getParameter("maSach")));
            sach.setTenSach(request.getParameter("tenSach"));
            sach.setTacGia(request.getParameter("tacGia"));
            sach.setGiaTien(Float.parseFloat(request.getParameter("giaTien")));
            sach.setHinhAnh(request.getParameter("hinhAnh"));
            int maTL = Integer.parseInt(request.getParameter("maTL"));
            TheLoai theLoai = new TheLoai();
            theLoai.setMaTL(maTL);
            sach.setMaTL(theLoai);
            sachDAO.update(sach);
            response.sendRedirect("sach?action=list");
        }
    }
}
