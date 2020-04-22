package Controller;


import jdbc.HomeworkJdbc;
import model.Homework;
import model.StudentHomework;
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
public class SubmitHomeworkController {
    private static ApplicationContext ct;
    static{
        ct=new AnnotationConfigApplicationContext(Homework.class);
    }
    @Before(value = "execution(* jdbc.HomeworkJdbc.*(..)) && args(h)")
    public void beforelog(Homework h){
        System.out.println("before添加作业");
    }

    @After(value = "execution(* jdbc.HomeworkJdbc.*(..)) && args(h)")
    public void afterlog(Homework h){
        System.out.println("after添加作业");
    }
    @RequestMapping(value = "submit_homework")

    public String addHomework(@RequestParam("sh_id") String sh_id ,
                              @RequestParam("s_id") String s_id ,
                              @RequestParam("h_id") String h_id,
                              @RequestParam("ht") String ht ,
                              @RequestParam("hc") String hc,
                              @RequestParam("ct") String ct ,
                              HttpServletRequest request){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentHomework sh = new StudentHomework();


        sh.setId(Long.parseLong(sh_id));
        sh.setStudentId(Long.parseLong(s_id));
        sh.setHomeworkId(Long.parseLong(h_id));
        sh.setHomeworkTitle(ht);
        sh.setHomeworkContent(hc);
        sh.setCreateTime(ct);


        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("app-servlet.xml");
        HomeworkJdbc sj=ac.getBean(HomeworkJdbc.class);
        sj.addHomework(sh);
        return "success.jsp";
    }


}
