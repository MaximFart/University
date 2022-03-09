package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherDao {

    void create(Teacher teacher);

    Optional<Teacher> getById(int id) throws DaoException;

    void update(Teacher teacher, int id);

    void delete(int id);

    List<Optional<Teacher>> findAll();
}
