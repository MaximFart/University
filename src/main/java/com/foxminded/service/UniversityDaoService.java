package com.foxminded.service;

import com.foxminded.dao.UniversityDao;
import com.foxminded.model.University;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityDaoService {

    private final UniversityDao universityDao;

    @Autowired
    public UniversityDaoService(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityDaoService.class);

    public void create(University university) throws UserInputException {
        universityDao.create(university);
    }

    public Optional<University> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return universityDao.getById(id);
    }

    public void update(University university, int id) throws UserInputException {
        universityDao.update(university, id);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        universityDao.delete(id);
    }

    public List<Optional<University>> findAll() {
        return universityDao.findAll();
    }
}
