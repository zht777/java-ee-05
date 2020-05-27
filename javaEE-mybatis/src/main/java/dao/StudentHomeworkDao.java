package dao;

import model.StudentHomework;

import java.util.List;

public interface StudentHomeworkDao {

    List<StudentHomework>   selectAll();;

    boolean add(StudentHomework sh);
}
