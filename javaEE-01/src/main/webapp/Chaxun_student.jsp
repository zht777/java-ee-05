<%@ page import="java.util.List" %>
<%@ page import="module.Student" %>
<%@ page import="jdbc.StudentJdbc" %>
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
            for (Student st : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=st.getId()%></td>
        <td><%=st.getName()%></td>
        <td><%=st.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
