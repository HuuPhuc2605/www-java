package iuh.fit.se.student.controller;

import iuh.fit.se.student.dao.StudentDAO;
import iuh.fit.se.student.model.Student;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        try {
            if (action == null) {
                List<Student> list = studentDAO.getAllStudent();
                request.setAttribute("studentList", list);
                request.getRequestDispatcher("views/student-list.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                studentDAO.deleteStudent(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("students");
            } else if (action.equals("edit")) {
                Student student = studentDAO.getStudentId(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("student", student);
                request.getRequestDispatcher("views/student-form.jsp").forward(request, response);
            } else if (action.equals("new")) {

                request.getRequestDispatcher("views/student-form.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            Student student = new Student(
                    id == null || id.isEmpty() ? 0 : Integer.parseInt(id),
                    request.getParameter("name"),
                    Integer.parseInt(request.getParameter("age")),
                    Boolean.parseBoolean(request.getParameter("gender")),
                    request.getParameter("image")

            );
            if (id == null || id.isEmpty()){
                studentDAO.addStudent(student);}
            else studentDAO.updateStudent(student);
            System.out.println("ID: " + request.getParameter("id"));
            System.out.println("NAME: " + request.getParameter("name"));
            System.out.println("AGE: " + request.getParameter("age"));
            System.out.println("GENDER: " + request.getParameter("gender"));
            System.out.println("IMAGE: " + request.getParameter("image"));
            response.sendRedirect("students");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
