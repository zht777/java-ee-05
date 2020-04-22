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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="ch"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Homework</title>
</head>
<body>

<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
    %>
    <ch:forEach items="${list}" var="list" varStatus="status">
        <tr align="center" bgcolor="white" height="30">
            <td>${list.id}</td>
            <td>${list.studentId}</td>
            <td>${list.homeworkId}</td>
            <td>${list.homeworkTitle}</td>
            <td>${list.homeworkContent}</td>
            <td>${list.createTime}</td>
        </tr>
    </ch:forEach>
    <%
        }
    %>
</table>
</body>
</html>
