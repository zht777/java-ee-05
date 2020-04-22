package Controller;

import model.Homework;
import jdbc.StudentHomeworkJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AddhomeworkController {
    @RequestMapping(value = "addhomework")
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

        StudentHomeworkJdbc studentHomeworkJdbc =(StudentHomeworkJdbc) applicationContext.getBean("StudentHomeworkJdbc_jdbc");
        studentHomeworkJdbc.addStudentHomework(hm);
        return "success.jsp";
    }


}
