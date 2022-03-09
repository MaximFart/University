package com.foxminded.service;

import com.foxminded.dao.CourseDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Course;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseDaoService {

    private final CourseDao courseDao;

    @Autowired
    public CourseDaoService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDaoService.class);

    public void create(Course course) {
        courseDao.create(course);
    }

    public Optional<Course> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return courseDao.getById(id);
    }

    public void update(Course course, int id) {
        courseDao.update(course, id);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        courseDao.delete(id);
    }

    public List<Optional<Course>> findAll() {
        return courseDao.findAll();
    }
}
