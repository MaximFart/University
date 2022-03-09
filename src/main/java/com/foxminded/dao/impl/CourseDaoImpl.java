package com.foxminded.dao.impl;

import com.foxminded.dao.CourseDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String QUERY_CREATE = "insert into course(id, name, description) values (?, ?, ?)";
    private final static String QUERY_GET_BY_ID = "select * from course where id = ?";
    private final static String QUERY_UPDATE = "update course set name = ?, description = ? where id = ?";
    private final static String QUERY_DELETE = "delete from course where id = ?";
    private final static String QUERY_FIND_ALL = "select * from course";

    @Override
    public void create(Course course) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Add new course {}", course);
        jdbcTemplate.update(QUERY_CREATE, course.getId(), course.getName(), course.getDescription());
        LOGGER.trace("Exit the method");
    }

    @Override
    public Optional<Course> getById(int id) throws DaoException {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get course by id {}", id);
        Optional<Course> course = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(Course.class), id)
                .stream().findAny();
        if (!course.isPresent()) {
            LOGGER.error("This course is empty {}", DaoException.class);
            throw new DaoException();
        }
        LOGGER.trace("Exit the method");
        return course;
    }

    @Override
    public void update(Course course, int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Update this course {}", course);
        LOGGER.trace("Exit the method");
        jdbcTemplate.update(QUERY_UPDATE, course.getName(), course.getDescription(),id);
    }

    @Override
    public void delete(int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Delete course by id {}", id);
        LOGGER.trace("Exit the method");
        jdbcTemplate.update(QUERY_DELETE, id);
    }

    @Override
    public List<Optional<Course>> findAll() {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get list courses");
        LOGGER.trace("Exit the method");
        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(Course.class)).stream().map(Optional::of).collect(Collectors.toList());
    }
}
