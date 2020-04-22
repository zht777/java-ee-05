package jdbc;

import model.Homework;
import model.Student;
import model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeworkJdbc {
    private static ApplicationContext ct;
    static{
        ct=new AnnotationConfigApplicationContext(StudentHomework.class);
    }

    public StudentHomework addHomework(StudentHomework sh){

        String sqlString = "INSERT INTO `s_student_homework(`id`, `student_id`, `homework_id`, `homework_title`, `homework_content`, `create_time`) VALUES('"+sh.getId()+"','"+sh.getStudentId()+','+sh.getHomeworkId()+','+sh.getHomeworkTitle()+"','"+sh.getHomeworkContent()+','+sh.getCreateTime()+"')";
        ApplicationContext ac = new ClassPathXmlApplicationContext("app-context.xml");
        DataSource ds = (DataSource)ac.getBean("datasource");

        Connection connection =null;
        try{
            connection = ds.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,sh.getId());
                ps.setLong(2,sh.getStudentId());
                ps.setLong(3,sh.getHomeworkId());
                ps.setString(4,sh.getHomeworkTitle());
                ps.setString(4,sh.getHomeworkContent());
                ps.setString(4,sh.getCreateTime());
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

        return sh;

    }
    public static List<Homework> selectAll(){

        String sqlString = "SELECT * FROM s_homework";

        ApplicationContext ac = new ClassPathXmlApplicationContext("app-context.xml");
        DataSource ds = (DataSource)ac.getBean("datasource");

        List<Homework> list = new ArrayList<>();
        try(Connection connection =  ds.getConnection()) {
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
