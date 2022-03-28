package com.foxminded.service;

import com.foxminded.jpa.DepartmentRepository;
import com.foxminded.model.Department;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentDaoService {

    private final DepartmentRepository departmentDao;

    @Autowired
    public DepartmentDaoService(DepartmentRepository departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void create(Department department) throws UserInputException {
        departmentDao.save(department);
    }

    public Optional<Department> getById(int id) throws Exception {
       return departmentDao.findById(id);
    }

    public void update(Department department) throws UserInputException {
        departmentDao.save(department);
    }

    public void delete(int id) throws UserInputException {
        departmentDao.deleteById(id);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
