package com.foxminded.dao.impl;

import com.foxminded.dao.DepartmentDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoImpl.class);


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String QUERY_CREATE = "insert into department(id, name) values (?, ?)";
    private final static String QUERY_GET_BY_ID = "select * from department where id = ?";
    private final static String QUERY_UPDATE = "update department set name = ? where id = ?";
    private final static String QUERY_DELETE = "delete from department where id = ?";
    private final static String QUERY_FIND_ALL = "select * from department";

    @Override
    public void create(Department department) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Create new department {}", department);
        jdbcTemplate.update(QUERY_CREATE, department.getId(), department.getName());
        LOGGER.trace("Exit the method");
    }

    @Override
    public Optional<Department> getById(int id) throws DaoException {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get department by id {}", id);
        Optional<Department> department = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(Department.class), id)
                .stream().findAny();
        if (!department.isPresent()) {
            LOGGER.error("This Department is empty {}", DaoException.class);
            throw  new DaoException();
        }
        LOGGER.trace("Exit the method");
        return department;
    }

    @Override
    public void update(Department department, int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Update this department {}", department);
        jdbcTemplate.update(QUERY_UPDATE, department.getName(), id);
        LOGGER.trace("Exit the method");
    }

    @Override
    public void delete(int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Delete department by id {}", id);
        jdbcTemplate.update(QUERY_DELETE, id);
        LOGGER.trace("Exit the method");
    }

    @Override
    public List<Optional<Department>> findAll() {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get list departments");
        LOGGER.trace("Exit the method");
        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(Department.class)).stream().map(Optional::of).collect(Collectors.toList());
    }
}
