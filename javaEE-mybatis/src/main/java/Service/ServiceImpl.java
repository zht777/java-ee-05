package Service;

import dao.HomeworkDao;
import dao.StudentDao;
import dao.StudentHomeworkDao;
import model.Homework;
import model.Student;
import model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ServiceImpl implements Service{
    private final HomeworkDao homeworkDao;
    private final StudentDao studentDao;
    private final StudentHomeworkDao studentHomeworkDao;


    @Autowired
    public ServiceImpl(HomeworkDao homeworkDao, StudentDao studentDao, StudentHomeworkDao studentHomeworkDao) {
        this.homeworkDao = homeworkDao;
        this.studentDao = studentDao;
        this.studentHomeworkDao = studentHomeworkDao;
    }

    public List<StudentHomework> showStudentHomework() {
        return studentHomeworkDao.selectAll();
    }

    public List<Student> showStudent() {
        return studentDao.selectAll();
    }

    public List<Homework> showHomework() {
        return homeworkDao.selectAll();
    }

    @Override
    public boolean submit(HttpServletRequest req) {
        StudentHomework sh = new StudentHomework();
        sh.setId(Long.parseLong(req.getParameter("sh_id")));
        sh.setStudentId(Long.parseLong(req.getParameter("s_id")));
        sh.setHomeworkId(Long.parseLong(req.getParameter("h_id")));
        sh.setHomeworkTitle(req.getParameter("ht"));
        sh.setHomeworkContent(req.getParameter("hc"));
        sh.setCreateTime(req.getParameter("ct"));

        return studentHomeworkDao.add(sh);
    }

    @Override
    public boolean addHomework(HttpServletRequest request) {
        Homework hm = new Homework();
        hm.setId(Long.parseLong(request.getParameter("hw_id")));
        hm.setName(request.getParameter("hw_name"));
        hm.setContent(request.getParameter("content"));
        hm.setCreateTime(request.getParameter("create_time"));

        return homeworkDao.add(hm);
    }

    @Override
    public boolean addstudent(HttpServletRequest req) {
        Student st = new Student();
        st.setId(Long.parseLong(req.getParameter("stu_id")));
        st.setName(req.getParameter("stu_name"));
        st.setCreateTime(req.getParameter("create_time"));
        return studentDao.add(st);
    }


}
