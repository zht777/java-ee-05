package Service;

import model.Homework;
import model.Student;
import model.StudentHomework;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Service {
    List<StudentHomework> showStudentHomework();
    List<Student> showStudent();
    List<Homework> showHomework();

    boolean submit(HttpServletRequest request);

    boolean addHomework(HttpServletRequest request);

    boolean addstudent(HttpServletRequest request);
}
