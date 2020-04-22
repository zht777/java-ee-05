<%--
  Created by IntelliJ IDEA.
  User: zht
  Date: 2020/3/13
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<center>
    <h1 style="color:red">添加学生</h1>
    <form id="indexform" name="indexForm" action="/student_system_war_exploded/addstudent" method="post">
        <table border="0">
            <tr>
                <td>学生ID</td>
                <td><input type="text" name="stu_id"></td>
            </tr>
            <tr>
                <td>学生名字</td>
                <td><input type="text" name="stu_name">
                </td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><input type="text" name="create_time">
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="确定" style="color:#BC8F8F">
    </form>
    <form action="teacher.jsp">
        <input type="submit" value="返回" style="color:#BC8F8F">
    </form>
</center>

</body>
</html>
