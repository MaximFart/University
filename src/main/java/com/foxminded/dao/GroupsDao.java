package com.foxminded.dao;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Groups;

import java.util.List;
import java.util.Optional;

public interface GroupsDao {

    void create(Groups groups);

    Optional<Groups> getById(int id) throws DaoException;

    void update(Groups groups, int id);

    void delete(int id);

    List<Optional<Groups>> findAll();
}
