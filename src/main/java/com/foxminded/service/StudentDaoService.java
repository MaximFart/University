package com.foxminded.service;

import com.foxminded.jpa.StudentRepository;
import com.foxminded.model.Student;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDaoService {

    private final StudentRepository studentDao;

    @Autowired
    public StudentDaoService(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }

    public void create(Student student) throws UserInputException {
        studentDao.save(student);
    }

    public Optional<Student> getById(int id) throws Exception {
        return studentDao.findById(id);
    }

    public void update(Student student) throws UserInputException {
        studentDao.save(student);
    }

    public void delete(int id) throws UserInputException {
        studentDao.deleteById(id);
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
