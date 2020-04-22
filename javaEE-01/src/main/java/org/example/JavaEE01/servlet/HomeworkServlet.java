package org.example.JavaEE01.servlet;

import org.example.JavaEE01.jdbc.HomeworkJdbc;
import org.example.JavaEE01.module.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Homeworklist")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list = HomeworkJdbc.selectAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("homework.jsp").forward(req, resp);
    }
}
