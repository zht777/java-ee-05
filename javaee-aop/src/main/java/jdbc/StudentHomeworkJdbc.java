package jdbc;

import model.Homework;
import model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    private static ApplicationContext ct;
    static{
        ct=new AnnotationConfigApplicationContext(Homework.class);
    }

    public Homework addStudentHomework(Homework hw){

        String sqlString = "INSERT INTO s_homework(`id`,`title`,`content`,`create_time`) VALUES('"+hw.getId()+"','"+hw.getName()+"','"+hw.getContent()+"','"+hw.getCreateTime()+"')";
        ApplicationContext ac = new ClassPathXmlApplicationContext("app-context.xml");
        DataSource ds = (DataSource)ac.getBean("datasource");

        Connection connection =null;

        try{
            connection = ds.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,hw.getId());
                ps.setString(2,hw.getName());
                ps.setString(3,hw.getContent());
                ps.setString(4,hw.getCreateTime());
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

        return hw;

    }

    public static List<StudentHomework> selectAll(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("app-context.xml");
        DataSource ds = (DataSource)ac.getBean("datasource");

        String sqlString = "SELECT * FROM s_student_homework";

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  ds.getConnection()) {
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
