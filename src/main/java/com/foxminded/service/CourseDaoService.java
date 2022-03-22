package com.foxminded.service;

import com.foxminded.dao.CourseDao;
import com.foxminded.dao.impl.CourseDaoImpl;
import com.foxminded.model.Course;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDaoService {

    private final CourseDao courseDao;

    @Autowired
    public CourseDaoService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDaoService.class);

    @Transactional
    public void create(Course course) {
        courseDao.create(course);
    }

    @Transactional
    public Optional<Course> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return courseDao.getById(id);
    }

    @Transactional
    public void update(Course course) {
        courseDao.update(course);
    }

    @Transactional
    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        courseDao.delete(id);
    }

    @Transactional
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
