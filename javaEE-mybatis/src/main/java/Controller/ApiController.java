package Controller;

import Service.ServiceImpl;
import model.Homework;
import model.Student;
import model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;


@RequestMapping("/")
@Controller
public class ApiController {

    private final ServiceImpl Service;
    @Autowired
    public ApiController(ServiceImpl allService) {
        this.Service = allService;
    }


    @RequestMapping(path = "/Homeworklist", method = RequestMethod.GET)
    public ModelAndView showHomework(){
        List<Homework> list = Service.showHomework();
        return new ModelAndView("/homework.jsp", "list", list);
    }

    @RequestMapping(path = "/Studentlist", method = RequestMethod.GET)
    public ModelAndView showStudent(){
        List<Student> list = Service.showStudent();
        return new ModelAndView("/Chaxun_student.jsp", "list", list);
    }

    @RequestMapping(path = "/StudentHomeworklist", method = RequestMethod.GET)
    public ModelAndView showStudentHomework(){
        List<StudentHomework> list = Service.showStudentHomework();
        return new ModelAndView("/Chaxun_homework.jsp", "list", list);
    }



    @RequestMapping(path = "/addHomework", method = RequestMethod.POST)
    public void addHomework(){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        boolean result = Service.addHomework(request);
        try {
            request.getRequestDispatcher("success.jsp").forward(request,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(path = "/addstudent", method = RequestMethod.POST)
    public void addstudent(){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        boolean result = Service.addstudent(request);
        try {
            request.getRequestDispatcher("success.jsp").forward(request,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(path = "/submit_homework", method = RequestMethod.POST)
    public void submit_homework(){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse resp = attributes.getResponse();
        boolean result = Service.submit(request);
        try {
            request.getRequestDispatcher("success.jsp").forward(request,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
