package com.foxminded.dao.impl;

import com.foxminded.dao.TeacherDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String QUERY_CREATE = "insert into teacher(id, email, position, first_name, last_name, age, timetable_id)" +
            " values (?, ?, ?, ?, ?, ?, ?)";
    private final static String QUERY_GET_BY_ID = "select * from teacher where id = ?";
    private final static String QUERY_UPDATE = "update teacher set email = ?, position = ?, first_name = ?," +
            " last_name = ?, age = ?, timetable_id = ? where id = ?";
    private final static String QUERY_DELETE = "delete from teacher where id = ?";
    private final static String QUERY_FIND_ALL = "select * from teacher";

    @Override
    public void create(Teacher teacher) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Create new teacher {}", teacher);
        jdbcTemplate.update(QUERY_CREATE, teacher.getId(), teacher.getEmail(),
                teacher.getPosition(), teacher.getFirstName(),
                teacher.getLastName(), teacher.getAge(),
                teacher.getTimetableId());
        LOGGER.trace("Exit the method");
    }

    @Override
    public Optional<Teacher> getById(int id) throws DaoException {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get teacher by id {}", id);
        Optional<Teacher> teacher = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(Teacher.class), id)
                .stream().findAny();
        if (!teacher.isPresent()) {
            LOGGER.error("This teacher is empty {}", DaoException.class);
            throw new DaoException();
        }
        LOGGER.trace("Exit the method");
        return teacher;
    }

    @Override
    public void update(Teacher teacher, int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Update this teacher {}", teacher);
        jdbcTemplate.update(QUERY_UPDATE, teacher.getEmail(),
                teacher.getPosition(), teacher.getFirstName(),
                teacher.getLastName(), teacher.getAge(),
                teacher.getTimetableId(), id);
        LOGGER.trace("Exit the method");
    }

    @Override
    public void delete(int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Delete teacher by id {}", id);
        jdbcTemplate.update(QUERY_DELETE, id);
        LOGGER.trace("Exit the method");
    }

    @Override
    public List<Optional<Teacher>> findAll() {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get list teachers");
        LOGGER.trace("Exit the method");
        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(Teacher.class)).stream().map(Optional::of).collect(Collectors.toList());
    }
}
