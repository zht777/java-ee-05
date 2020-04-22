package Controller;


import model.StudentHomework;
import jdbc.HomeworkJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SubmitHomeworkController {
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

        HomeworkJdbc homeworkJdbc =(HomeworkJdbc) applicationContext.getBean("Homework_jdbc");
        homeworkJdbc.addHomework(sh);
        return "success.jsp";
    }


}
