package org.example.JavaEE01.servlet;

import org.example.JavaEE01.jdbc.StudentJdbc;
import org.example.JavaEE01.module.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student st = new Student();
        /**
         * 赋值
         */
        req.setCharacterEncoding("utf-8");
        st.setId(Long.parseLong(req.getParameter("stu_id")));
        st.setName(req.getParameter("stu_name"));
        st.setCreateTime(req.getParameter("create_time"));

        StudentJdbc.addStudent(st);

        resp.sendRedirect("success.jsp");
    }
}
