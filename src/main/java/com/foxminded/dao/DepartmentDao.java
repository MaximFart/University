package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentDao {

    void create(Department department);

    Optional<Department> getById(int id) throws DaoException;

    void update(Department department, int id);

    void delete(int id);

    List<Optional<Department>> findAll();
}
