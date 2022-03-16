package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDao {

    void create(Course course);

    Optional<Course> getById(int id) throws DaoException;

    void update(Course course);

    void delete(int id);

    List<Course> findAll();
}
