//package com.foxminded.service;
//
//import com.foxminded.dao.TeacherDao;
//import com.foxminded.dao.exception.DaoException;
//import com.foxminded.model.Teacher;
//import com.foxminded.service.exception.UserInputException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TeacherDaoService {
//
//    private final TeacherDao teacherDao;
//
//    @Autowired
//    public TeacherDaoService(TeacherDao teacherDao) {
//        this.teacherDao = teacherDao;
//    }
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherDaoService.class);
//
//    public void create(Teacher teacher) throws UserInputException {
//        teacherDao.create(teacher);
//    }
//
//    public Optional<Teacher> getById(int id) throws Exception {
//        try {
//            Integer.parseInt(Integer.toString(id));
//        } catch (Exception e) {
//            LOGGER.error("Incorrect input {}", UserInputException.class);
//            throw new UserInputException();
//        }
//        return teacherDao.getById(id);
//    }
//
//    public void update(Teacher teacher, int id) throws UserInputException {
//        teacherDao.update(teacher, id);
//    }
//
//    public void delete(int id) throws UserInputException {
//        try {
//            Integer.parseInt(Integer.toString(id));
//        } catch (Exception e) {
//            LOGGER.error("Incorrect input {}", UserInputException.class);
//            throw new UserInputException();
//        }
//        teacherDao.delete(id);
//    }
//
//    public List<Optional<Teacher>> findAll() {
//        return teacherDao.findAll();
//    }
//}
