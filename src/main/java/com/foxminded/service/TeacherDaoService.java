package com.foxminded.service;

import com.foxminded.jpa.TeacherRepository;
import com.foxminded.model.Teacher;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherDaoService {

    private final TeacherRepository teacherDao;

    @Autowired
    public TeacherDaoService(TeacherRepository teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void create(Teacher teacher) throws UserInputException {
        teacherDao.save(teacher);
    }

    public Optional<Teacher> getById(int id) throws Exception {
        return teacherDao.findById(id);
    }

    public void update(Teacher teacher) throws UserInputException {
        teacherDao.save(teacher);
    }

    public void delete(int id){
        teacherDao.deleteById(id);
    }

    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }
}
