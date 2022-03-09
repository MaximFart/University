package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    void create(Student student);

    Optional<Student> getById(int id) throws DaoException;

    void update(Student student, int id);

    void delete(int id);

    List<Optional<Student>> findAll();
}
