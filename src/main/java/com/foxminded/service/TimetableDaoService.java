package com.foxminded.service;

import com.foxminded.dao.TimetableDao;
import com.foxminded.model.Timetable;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableDaoService {

    private final TimetableDao timetableDao;

    @Autowired
    public TimetableDaoService(TimetableDao timetableDao) {
        this.timetableDao = timetableDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TimetableDaoService.class);

    public void create(Timetable timetable) throws UserInputException {
        timetableDao.create(timetable);
    }

    public Optional<Timetable> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return timetableDao.getById(id);
    }

    public void update(Timetable timetable, int id) throws UserInputException {
        timetableDao.update(timetable, id);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        timetableDao.delete(id);
    }

    public List<Optional<Timetable>> findAll() {
        return timetableDao.findAll();
    }
}
