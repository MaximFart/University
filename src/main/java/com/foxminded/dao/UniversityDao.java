package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.University;


import java.util.List;
import java.util.Optional;

public interface UniversityDao {

    void create(University university);

    Optional<University> getById(int id) throws DaoException;

    void update(University university, int id);

    void delete(int id);

    List<Optional<University>> findAll();
}
