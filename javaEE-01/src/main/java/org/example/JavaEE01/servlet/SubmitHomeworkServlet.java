package org.example.JavaEE01.servlet;


import org.example.JavaEE01.jdbc.HomeworkJdbc;
import org.example.JavaEE01.module.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submit_homework")
public class SubmitHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentHomework sh = new StudentHomework();
        /**
         * 赋值
         */
        req.setCharacterEncoding("utf-8");
        sh.setId(Long.parseLong(req.getParameter("sh_id")));
        sh.setStudentId(Long.parseLong(req.getParameter("s_id")));
        sh.setHomeworkId(Long.parseLong(req.getParameter("h_id")));
        sh.setHomeworkTitle(req.getParameter("ht"));
        sh.setHomeworkContent(req.getParameter("hc"));
        sh.setCreateTime(req.getParameter("ct"));

        HomeworkJdbc.addHomework(sh);

        resp.sendRedirect("success.jsp");
    }
}
