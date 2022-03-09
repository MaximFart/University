package com.foxminded.dao.impl;

import com.foxminded.dao.TimetableDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Timetable;
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
public class TimetableDaoImpl implements TimetableDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimetableDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TimetableDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String QUERY_CREATE = "insert into timetable(id, date, groups_id, teacher_id, course_id) values (?, ?, ?, ?, ?)";
    private final static String QUERY_GET_BY_ID = "select * from timetable where id = ?";
    private final static String QUERY_UPDATE = "update timetable set date = ?, groups_id = ?, teacher_id = ?, course_id = ? where id = ?";
    private final static String QUERY_DELETE = "delete from timetable where id = ?";
    private final static String QUERY_FIND_ALL = "select * from timetable";

    @Override
    public void create(Timetable timetable) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Create new timetable {}", timetable);
        jdbcTemplate.update(QUERY_CREATE, timetable.getId(), timetable.getDate(),
                timetable.getGroupsId(), timetable.getTeacherId(),
                timetable.getCourseId());
        LOGGER.trace("Exit the method");
    }

    @Override
    public Optional<Timetable> getById(int id) throws DaoException {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get timetable by id {}", id);
        Optional<Timetable> timetable = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(Timetable.class), id)
                .stream().findAny();
        if (!timetable.isPresent()) {
            LOGGER.error("This timetable is empty {}", DaoException.class);
            throw new DaoException();
        }
        LOGGER.trace("Exit the method");
        return timetable;
    }

    @Override
    public void update(Timetable timetable, int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Update this timetable {}", timetable);
        jdbcTemplate.update(QUERY_UPDATE, timetable.getDate(),
                timetable.getGroupsId(), timetable.getTeacherId(),
                timetable.getCourseId(), id);
        LOGGER.trace("Exit the method");
    }

    @Override
    public void delete(int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Delete timetable by id {}", id);
        jdbcTemplate.update(QUERY_DELETE, id);
        LOGGER.trace("Exit the method");
    }

    @Override
    public List<Optional<Timetable>> findAll() {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get list timetables");
        LOGGER.trace("Exit the method");
        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(Timetable.class)).stream().map(Optional::of).collect(Collectors.toList());
    }
}
