package Controller;

import jdbc.StudentHomeworkJdbc;
import jdbc.StudentJdbc;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Controller
public class AddStudentController {
    private static ApplicationContext ct;
    static{
        ct=new AnnotationConfigApplicationContext(Student.class);
    }
    @Before(value = "execution(* jdbc.StudentJdbc.*(..)) && args(st)")
    public void beforelog(Student st){
        System.out.println("before添加学生："+st.getName());
        System.out.println("before添加学生");
    }

    @After(value = "execution(* jdbc.StudentJdbc.*(..)) && args(st)")
    public void afterlog(Student st){
        System.out.println("after添加学生");
        System.out.println("after添加学生："+st.getName());
    }

    @RequestMapping(value = "addstudent")
    public String addHomework(@RequestParam("stu_id") String stu_id ,
                              @RequestParam("stu_name") String stu_name ,
                              @RequestParam("create_time") String create_time ,
                              HttpServletRequest request){
        Student st = new Student();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        st.setId(Long.parseLong(stu_id));
        st.setName(stu_name);
        st.setCreateTime(create_time);

        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("app-servlet.xml");
        StudentJdbc sj=ac.getBean(StudentJdbc.class);
        sj.addStudent(st);
        return "success.jsp";

    }

}
