package com.foxminded.service;

import com.foxminded.jpa.CourseRepository;
import com.foxminded.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDaoService {

    private final CourseRepository courseDao;

    @Autowired
    public CourseDaoService(CourseRepository courseDao) {
        this.courseDao = courseDao;
    }

    public void create(Course course) {
        courseDao.save(course);
    }

    public Optional<Course> getById(int id) throws Exception {
        return courseDao.findById(id);
    }

    public void update(Course course) throws Exception {
        courseDao.save(course);
    }

    public void delete(int id) throws Exception {
        courseDao.deleteById(id);
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
