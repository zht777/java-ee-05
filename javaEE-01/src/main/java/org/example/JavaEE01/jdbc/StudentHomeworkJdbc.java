package org.example.JavaEE01.jdbc;

import org.example.JavaEE01.module.Homework;
import org.example.JavaEE01.module.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static void addStudentHomework(Homework hw){

        String url = "jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user="root";

        String password="root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "INSERT INTO s_homework(`id`,`title`,`content`,`create_time`) VALUES('"+hw.getId()+"','"+hw.getName()+"','"+hw.getContent()+"','"+hw.getCreateTime()+"')";
        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection =  DriverManager.getConnection(url, user, password)) {
            try(Statement statement = connection.createStatement()){
                statement.executeUpdate(sqlString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<StudentHomework> selectAll(){

        String url = "jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user="root";

        String password="root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url, user, password)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getString("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
