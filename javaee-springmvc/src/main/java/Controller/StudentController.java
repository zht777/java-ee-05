package Controller;

import model.Student;
import jdbc.StudentJdbc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@WebServlet("/Studentlist")
public class StudentController {
    @RequestMapping(value = "Studentlist")
    public String getHomeworkList(Model model, HttpServletRequest request){
        List<Student> list = StudentJdbc.selectAll();
        model.addAttribute("list", list);
        return "Chaxun_student.jsp";
    }
}