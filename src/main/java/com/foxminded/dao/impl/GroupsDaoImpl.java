//package com.foxminded.dao.impl;
//import com.foxminded.dao.GroupsDao;
//import com.foxminded.dao.exception.DaoException;
//import com.foxminded.model.Groups;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class GroupsDaoImpl implements GroupsDao {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(GroupsDaoImpl.class);
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public GroupsDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private final static String QUERY_CREATE = "insert into groups(id, name) values (?, ?)";
//    private final static String QUERY_GET_BY_ID = "select * from groups where id = ?";
//    private final static String QUERY_UPDATE = "update groups set name = ? where id = ?";
//    private final static String QUERY_DELETE = "delete from groups where id = ?";
//    private final static String QUERY_FIND_ALL = "select * from groups";
//
//    @Override
//    public void create(Groups groups) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Create new group {}", groups);
//        jdbcTemplate.update(QUERY_CREATE, groups.getId(), groups.getName());
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public Optional<Groups> getById(int id) throws DaoException {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get group by id {}", id);
//        Optional<Groups> groups = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(Groups.class), id)
//                .stream().findAny();
//        if (!groups.isPresent()) {
//            LOGGER.error("This group is empty {}", DaoException.class);
//            throw new DaoException();
//        }
//        LOGGER.trace("Exit the method");
//        return groups;
//    }
//
//    @Override
//    public void update(Groups groups, int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Update this groups {}", groups);
//        jdbcTemplate.update(QUERY_UPDATE, groups.getName(), id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public void delete(int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Delete group by id {}", id);
//        jdbcTemplate.update(QUERY_DELETE, id);
//        LOGGER.trace("Exit the method");
//    }
//
//    public List<Optional<Groups>> findAll() {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get list groups");
//        LOGGER.trace("Exit the method");
//        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(Groups.class)).stream().map(Optional::of).collect(Collectors.toList());
//    }
//}
