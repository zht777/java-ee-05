package jdbc;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId((long) 2);
        s.setName("李四");
        s.setCreateTime("2020-03-03 12:00:00");
        addStudent(s);
    }

    public static void addStudent(Student st){

        String url = "jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user="root";

        String password="root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "INSERT INTO s_student(`id`,`name`,`create_time`) VALUES('"+st.getId()+"','"+st.getName()+"','"+st.getCreateTime()+"')";

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
    public static List<Student> selectAll(){

        String url = "jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user="root";

        String password="root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url, user, password)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Student st = new Student();
                        st.setId(resultSet.getLong("id"));
                        st.setName(resultSet.getString("name"));
                        st.setCreateTime(resultSet.getString("create_time"));
                        list.add(st);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
