package org.example.JavaEE01.jdbc;

import org.example.JavaEE01.module.Homework;
import org.example.JavaEE01.module.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeworkJdbc {
    public static void addHomework(StudentHomework sh){

        String url = "jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user="root";

        String password="root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "INSERT INTO `s_student_homework(`id`, `student_id`, `homework_id`, `homework_title`, `homework_content`, `create_time`) VALUES('"+sh.getId()+"','"+sh.getStudentId()+','+sh.getHomeworkId()+','+sh.getHomeworkTitle()+"','"+sh.getHomeworkContent()+','+sh.getCreateTime()+"')";

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
    public static List<Homework> selectAll(){

        String url = "jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user="root";

        String password="root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Homework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url, user, password)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Homework hw = new Homework();
                        hw.setId(resultSet.getLong("id"));
                        hw.setName(resultSet.getString("title"));
                        hw.setContent(resultSet.getString("content"));
                        hw.setCreateTime(resultSet.getString("create_time"));
                        list.add(hw);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
