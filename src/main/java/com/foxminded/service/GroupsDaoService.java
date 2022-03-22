package com.foxminded.service;

import com.foxminded.dao.GroupsDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Groups;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsDaoService {

    @Autowired
    private GroupsDao groupsDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupsDaoService.class);

    public void create(Groups groups) throws UserInputException {
        groupsDao.save(groups);
    }

    public Optional<Groups> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return groupsDao.findById(id);
    }

    public void update(Groups groups, int id) throws UserInputException, DaoException {
        if (groupsDao.findById(id).isPresent()) {
            Groups ThisGroups = groupsDao.findById(id).get();
            ThisGroups.setName(groups.getName());
            groupsDao.save(ThisGroups);
        } else {
            throw new DaoException("Groups is empty: " + groupsDao.getById(id));
        }
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        groupsDao.deleteById(id);
    }

    public List<Groups> findAll() {
        return groupsDao.findAll();
    }
}
