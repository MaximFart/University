package com.foxminded.service;

import com.foxminded.dao.DepartmentDao;
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

    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentDaoService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoService.class);

    public void create(Department department) throws UserInputException {
        departmentDao.create(department);
    }

    public Optional<Department> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return departmentDao.getById(id);
    }

    public void update(Department department) throws UserInputException {

        departmentDao.update(department);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        departmentDao.delete(id);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
