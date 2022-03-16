//package com.foxminded.dao.impl;
//
//import com.foxminded.dao.StudentCourseDao;
//import com.foxminded.dao.exception.DaoException;
//import com.foxminded.model.StudentCourse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class StudentCourseDaoImpl implements StudentCourseDao {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoImpl.class);
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public StudentCourseDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private final static String QUERY_CREATE = "insert into student_course(id, student_id, course_id) values (?, ?, ?)";
//    private final static String QUERY_GET_BY_ID = "select * from student_course where id = ?";
//    private final static String QUERY_UPDATE = "update student_course set student_id = ?, course_id = ? where id = ?";
//    private final static String QUERY_DELETE = "delete from student_course where id = ?";
//    private final static String QUERY_FIND_ALL = "select * from student_course";
//
//    @Override
//    public void create(StudentCourse studentCourse) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Create new student_course {}", studentCourse);
//        jdbcTemplate.update(QUERY_CREATE, studentCourse.getId(), studentCourse.getStudentId(), studentCourse.getCourseId());
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public Optional<StudentCourse> getById(int id) throws DaoException {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get student_course by id {}", id);
//        Optional<StudentCourse> studentCourse = jdbcTemplate.query(QUERY_GET_BY_ID, new BeanPropertyRowMapper<>(StudentCourse.class), id)
//                .stream().findAny();
//        if (!studentCourse.isPresent()) {
//            LOGGER.error("This student_course is empty {}", DaoException.class);
//            throw new DaoException();
//        }
//        LOGGER.trace("Exit the method");
//        return studentCourse;
//    }
//
//    @Override
//    public void update(StudentCourse studentCourse, int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Update this student_course {}", studentCourse);
//        jdbcTemplate.update(QUERY_UPDATE, studentCourse.getStudentId(), studentCourse.getCourseId(), id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public void delete(int id) {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Delete student_course by id {}", id);
//        jdbcTemplate.update(QUERY_DELETE, id);
//        LOGGER.trace("Exit the method");
//    }
//
//    @Override
//    public List<Optional<StudentCourse>> findAll() {
//        LOGGER.trace("Enter the method");
//        LOGGER.debug("Get list student_courses");
//        LOGGER.trace("Exit the method");
//        return jdbcTemplate.query(QUERY_FIND_ALL, new BeanPropertyRowMapper<>(StudentCourse.class)).stream().map(Optional::of).collect(Collectors.toList());
//    }
//}
