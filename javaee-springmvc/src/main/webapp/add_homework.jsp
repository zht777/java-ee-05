<%--
  Created by IntelliJ IDEA.
  User: zht
  Date: 2020/3/13
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>添加作业</title>
</head>
<body>
<center>
    <h1 style="color:red">添加作业</h1>
    <form id="indexform" name="/addhomework" action="/student_system_war_exploded/addhomework" method="post">
        <table border="0">
            <tr>
                <td>id：</td>
                <td><input type="text" name="hw_id"></td>
            </tr>
            <tr>
                <td>作业名字</td>
                <td><input type="text" name="hw_name"></td>
            </tr>
            <tr>
                <td>作业内容</td>
                <td><input type="text" name="content"></td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><input type="text" name="create_time"></td>
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
