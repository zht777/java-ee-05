<%@ page import="java.util.List" %>
<%@ page import="Bean.Student" %>
<%@ page import="jdbc.StudentJdbc" %>
<%--
  Created by IntelliJ IDEA.
  User: zht
  Date: 2020/3/11
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
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
        <td>学生姓名</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Student> list = StudentJdbc.selectAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
    %>
    <s:forEach items="${list}" var="list" varStatus="status">
        <tr align="center" bgcolor="white" height="30">
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.createTime}</td>
        </tr>
    </s:forEach>
    <%

        }
    %>
</table>
</body>
</html>
