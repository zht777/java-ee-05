package org.example.JavaEE01.servlet;

import org.example.JavaEE01.jdbc.StudentHomeworkJdbc;
import org.example.JavaEE01.module.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentHomeworklist")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("Chaxun_homework.jsp").forward(req, resp);
    }
}
