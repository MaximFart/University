package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Timetable;

import java.util.List;
import java.util.Optional;

public interface TimetableDao {

    void create(Timetable timetable);

    Optional<Timetable> getById(int id) throws DaoException;

    void update(Timetable timetable, int id);

    void delete(int id);

    List<Optional<Timetable>> findAll();
}
