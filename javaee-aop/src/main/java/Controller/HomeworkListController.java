package Controller;

import jdbc.HomeworkJdbc;
import model.Homework;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeworkListController {
    @RequestMapping(value = "Homeworklist")
    public String getHomeworkList(Model model, HttpServletRequest request){
        List<Homework> list = HomeworkJdbc.selectAll();
        model.addAttribute("list", list);
        return "homework.jsp";
    }

}
