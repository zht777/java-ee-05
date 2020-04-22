<%--
  Created by IntelliJ IDEA.
  User: zht
  Date: 2020/3/13
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
<center>
    <h1 style="color:red">提交作业</h1>
    <form id="indexform" name="/addhomework" action="/student_system_war_exploded/submit_homework" method="post">
        <table border="0">
            <tr>
                <td>提交id：</td>
                <td><input type="text" name="sh_id"></td>
            </tr>
            <tr>
                <td>作业id：</td>
                <td><input type="text" name="h_id"></td>
            </tr>
            <tr>
                <td>学生id：</td>
                <td><input type="text" name="s_id"></td>
            </tr>
            <tr>
                <td>作业标题</td>
                <td><input type="text" name="ht"></td>
            </tr>
            <tr>
                <td>作业内容</td>
                <td><input type="text" name="hc"></td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><input type="text" name="ct"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="确定" style="color:#BC8F8F">
    </form>
    <form action="student.jsp">
        <input type="submit" value="返回" style="color:#BC8F8F">
    </form>
</center>

</body>
</html>
