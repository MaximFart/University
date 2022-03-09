package com.foxminded.service;

import com.foxminded.dao.StudentDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Student;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDaoService {

    private final StudentDao studentDao;

    @Autowired
    public StudentDaoService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoService.class);

    public void create(Student student) throws UserInputException {
        studentDao.create(student);
    }

    public Optional<Student> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return studentDao.getById(id);
    }

    public void update(Student student, int id) throws UserInputException {
        studentDao.update(student, id);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        studentDao.delete(id);
    }

    public List<Optional<Student>> findAll() {
        return studentDao.findAll();
    }
}
