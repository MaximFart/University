package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.StudentCourse;

import java.util.List;
import java.util.Optional;

public interface StudentCourseDao {

    void create(StudentCourse studentCourse);

    Optional<StudentCourse> getById(int id) throws DaoException;

    void update(StudentCourse studentCourse, int id);

    void delete(int id);

    List<Optional<StudentCourse>> findAll();
}
