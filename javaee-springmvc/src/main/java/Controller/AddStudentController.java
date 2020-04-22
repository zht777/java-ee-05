package Controller;

import model.Student;
import jdbc.StudentJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AddStudentController {
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

        StudentJdbc  studentJdbc =(StudentJdbc) applicationContext.getBean("Student_jdbc");
        studentJdbc.addStudent(st);
        return "success.jsp";

    }

}
