package Controller;

import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Controller
public class AddhomeworkController {
    private static ApplicationContext ct;
    static{
        ct=new AnnotationConfigApplicationContext(StudentHomework.class);
    }

    @Before(value = "execution(* jdbc.HomeworkJdbc.*(..)) && args(hm)")
    public void beforelog(Homework hm){
        System.out.println("before添加作业");
    }

    @After(value = "execution(* jdbc.HomeworkJdbc.*(..)) && args(hm)")
    public void afterlog(Homework hm){
        System.out.println("after添加作业");
    }

    @RequestMapping(value = "addhomework",method = RequestMethod.POST)
    public String addHomework(@RequestParam("hw_id") String hw_id ,
                              @RequestParam("hw_name") String hw_name ,
                              @RequestParam("content") String content,
                              @RequestParam("create_time") String create_time ,
                              HttpServletRequest request){
        Homework hm = new Homework();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        hm.setId(Long.parseLong(hw_id));
        hm.setName(hw_name);
        hm.setContent(content);
        hm.setCreateTime(create_time);

        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("app-servlet.xml");
        StudentHomeworkJdbc sj=ac.getBean(StudentHomeworkJdbc.class);
        sj.addStudentHomework(hm);
        return "success.jsp";
    }


}
