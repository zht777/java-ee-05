<%@ page import="Bean.Homework" %>
<%@ page import="jdbc.HomeworkJdbc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zht
  Date: 2020/3/13
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业要求</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Homework> list = HomeworkJdbc.selectAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
    %>
    <h:forEach items="${list}" var="list" varStatus="status">
        <tr align="center" bgcolor="white" height="30">
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.content}</td>
            <td>${list.createTime}</td>
        </tr>
    </h:forEach>
    <%
        }
    %>

</table>

</body>
</html>
