package iuh.fit.libraryapp.servlet;

import iuh.fit.libraryapp.dao.impl.TheLoaiDAOImpl;
import iuh.fit.libraryapp.model.TheLoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/theloai")
public class TheLoaiServlet extends HttpServlet {
private TheLoaiDAOImpl theLoaiDAO = new TheLoaiDAOImpl();
protected  void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    List<TheLoai> list =theLoaiDAO.getAll();
    request.setAttribute("theloaiList", list);
    request.getRequestDispatcher("views/theloai.jsp").forward(request, response);
}}
