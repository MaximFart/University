//package com.foxminded.dao.impl;
//
//import com.foxminded.dao.UniversityDao;
//import com.foxminded.dao.exception.DaoException;
//import com.foxminded.model.University;
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
//public class UniversityDaoImpl implements UniversityDao {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityDaoImpl.class);
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public UniversityDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private final static String QUERY_CREATE = "insert into university(id, name) values (?, ?)";
//    private final static String QUERY_GET_BY_ID = "select * from university where id = ?";
//    private final static String QUERY_UPDATE = "update university set name = ? where id = ?";
//    private final static String QUERY_DELETE = "delete from university where id = ?";
//    private final static String QUERY_FIND_ALL = "select * from university";
//
//    @Override
//    public void create(University university) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Create new university {}", university);
//        jdbcTemplate.update(QUERY_CREATE, university.getId(), university.getName());
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public Optional<University> getById(int id) throws DaoException {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get university by id {}", id);
//        Optional<University> university = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(University.class), id)
//                .stream().findAny();
//        if (!university.isPresent()) {
//            LOGGER.error("This university is empty {}", DaoException.class);
//            throw new DaoException();
//        }
//        LOGGER.trace("Exit the method");
//        return university;
//    }
//
//    @Override
//    public void update(University university, int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Update this university {}", university);
//        jdbcTemplate.update(QUERY_UPDATE, university.getName(), id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public void delete(int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Delete university by id {}", id);
//        jdbcTemplate.update(QUERY_DELETE, id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public List<Optional<University>> findAll() {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get list universities");
//        LOGGER.trace("Exit the method");
//        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(University.class)).stream().map(Optional::of).collect(Collectors.toList());
//    }
//}
