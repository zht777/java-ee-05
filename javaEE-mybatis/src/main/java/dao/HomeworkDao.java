package dao;

import model.Homework;

import java.util.List;

public interface HomeworkDao {


    List<Homework> selectAll();

    boolean add(Homework hm);
}
