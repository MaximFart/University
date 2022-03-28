package com.foxminded.service;

import com.foxminded.jpa.UniversityRepository;
import com.foxminded.model.University;
import com.foxminded.service.exception.UserInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityDaoService {

    private final UniversityRepository universityDao;

    @Autowired
    public UniversityDaoService(UniversityRepository universityDao) {
        this.universityDao = universityDao;
    }

    public void create(University university) {
        universityDao.save(university);
    }

    public Optional<University> getById(int id) throws Exception {
        return universityDao.findById(id);
    }

    public void update(University university) {
        universityDao.save(university);
    }

    public void delete(int id) throws UserInputException {
        universityDao.deleteById(id);
    }

    public List<University> findAll() {
        return universityDao.findAll();
    }
}
