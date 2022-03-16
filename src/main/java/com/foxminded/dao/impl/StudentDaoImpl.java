//package com.foxminded.dao.impl;
//
//import com.foxminded.dao.StudentDao;
//import com.foxminded.dao.exception.DaoException;
//import com.foxminded.model.Student;
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
//public class StudentDaoImpl implements StudentDao {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoImpl.class);
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private final static String QUERY_CREATE = "insert into student(id, groups_id, first_name, last_name, age, timetable_id) values (?, ?, ?, ?, ?, ?)";
//    private final static String QUERY_GET_BY_ID = "select * from student where id = ?";
//    private final static String QUERY_UPDATE = "update student set groups_id = ?, first_name = ?, last_name = ?, age = ?, timetable_id = ? where id = ?";
//    private final static String QUERY_DELETE = "delete from student where id = ?";
//    private final static String QUERY_FIND_ALL = "select * from student";
//
//    @Override
//    public void create(Student student) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Create new Student {}", student);
//        jdbcTemplate.update(QUERY_CREATE,
//                student.getId(), student.getGroupsId(),
//                student.getFirstName(), student.getLastName(),
//                student.getAge(), student.getTimetableId());
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public Optional<Student> getById(int id) throws DaoException {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get student by id {}", id);
//        Optional<Student> student = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(Student.class), new Object[]{id})
//                .stream().findAny();
//        if (!student.isPresent()) {
//            LOGGER.error("This Student is empty {}", DaoException.class);
//            throw new DaoException();
//        }
//        LOGGER.trace("Exit the method");
//        return student;
//    }
//
//    @Override
//    public void update(Student student, int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Update this student {}", student);
//        jdbcTemplate.update(QUERY_UPDATE, student.getGroupsId(), student.getFirstName(),
//                student.getLastName(), student.getAge(), student.getTimetableId(), id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public void delete(int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Delete student by id {}", id);
//        jdbcTemplate.update(QUERY_DELETE, id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public List<Optional<Student>> findAll() {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get list students");
//        LOGGER.trace("Exit the method");
//        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(Student.class)).stream().map(Optional::of).collect(Collectors.toList());
//    }
//}
