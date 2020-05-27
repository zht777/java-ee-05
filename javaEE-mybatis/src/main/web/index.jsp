<%@ page import="Bean.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="jdbc.StudentHomeworkJdbc" %>
<%--
  Created by IntelliJ IDEA.
  User: zht
  Date: 2020/3/11
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>作业管理系统</title>
</head>
<body>
<body>
<center>
  <h1 style="color:red">欢迎进入作业管理系统，选择你的身份</h1>
  <br>
  <a href="teacher.jsp" style="color:blue;font-size:30px" >老师</a>
  <br>
  <a href="student.jsp" style="color:blue;font-size:30px" >学生</a>
</center>
</body>
</html>
