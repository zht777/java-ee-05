package org.example.JavaEE01.servlet;

import org.example.JavaEE01.jdbc.StudentJdbc;
import org.example.JavaEE01.module.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Studentlist")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = StudentJdbc.selectAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("Chaxun_student.jsp").forward(req, resp);
    }
}