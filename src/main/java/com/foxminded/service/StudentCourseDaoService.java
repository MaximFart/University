package com.foxminded.service;

import com.foxminded.dao.StudentCourseDao;
import com.foxminded.model.StudentCourse;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseDaoService {

    private final StudentCourseDao studentCourseDao;

    @Autowired
    public StudentCourseDaoService(StudentCourseDao studentCourseDao) {
        this.studentCourseDao = studentCourseDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCourseDaoService.class);

    public void create(StudentCourse studentCourse) throws UserInputException {

        studentCourseDao.create(studentCourse);
    }

    public Optional<StudentCourse> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return studentCourseDao.getById(id);
    }

    public void update(StudentCourse studentCourse, int id) throws UserInputException {
        studentCourseDao.update(studentCourse, id);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        studentCourseDao.delete(id);
    }

    public List<Optional<StudentCourse>> findAll() {
        return studentCourseDao.findAll();
    }
}
