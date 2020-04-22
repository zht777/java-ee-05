package Controller;

import model.StudentHomework;
import jdbc.StudentHomeworkJdbc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentHomeworkController {
    @RequestMapping(value = "StudentHomeworklist")
    public String getHomeworkList(Model model, HttpServletRequest request){
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll();
        model.addAttribute("list", list);
        return "Chaxun_homework.jsp";
    }
}
