package jdbc;

import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    private static ApplicationContext ct;
    static{
        ct=new AnnotationConfigApplicationContext(Student.class);
    }

    public Student addStudent(Student st){


        String sqlString = "INSERT INTO s_student(`id`,`name`,`create_time`) VALUES('"+st.getId()+"','"+st.getName()+"','"+st.getCreateTime()+"')";
        ApplicationContext ac = new ClassPathXmlApplicationContext("app-context.xml");
        DataSource ds = (DataSource)ac.getBean("datasource");

        Connection connection =null;
        try{
            connection = ds.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,st.getId());
                ps.setString(4,st.getName());
                ps.setString(4,st.getCreateTime());
                ps.executeUpdate();
                connection.commit();

            }
        } catch (SQLException e) {
            try {
                if(connection!=null) {
                    connection.rollback();
                }
            } catch (Exception e2) {
                // handle exception
            }
        }finally{
            try {
                if(connection!=null) {
                    connection.rollback();
                }
            } catch (Exception e2) {
                //handle exception
            }
        }

        return st;

    }
    public static List<Student> selectAll(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("app-context.xml");
        DataSource ds = (DataSource)ac.getBean("datasource");
        String sqlString = "SELECT * FROM s_student";


        List<Student> list = new ArrayList<>();
        try(Connection connection =  ds.getConnection()) {
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
