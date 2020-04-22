package org.example.JavaEE01.servlet;

import org.example.JavaEE01.jdbc.StudentHomeworkJdbc;
import org.example.JavaEE01.module.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addhomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Homework hm = new Homework();

        req.setCharacterEncoding("utf-8");
        hm.setId(Long.parseLong(req.getParameter("hw_id")));
        hm.setName(req.getParameter("hw_name"));
        hm.setContent(req.getParameter("content"));
        hm.setCreateTime(req.getParameter("create_time"));

        StudentHomeworkJdbc.addStudentHomework(hm);

        resp.sendRedirect("success.jsp");
    }

}
