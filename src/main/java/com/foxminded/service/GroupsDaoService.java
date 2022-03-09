package com.foxminded.service;

import com.foxminded.dao.GroupsDao;
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

    private final GroupsDao groupsDao;

    @Autowired
    public GroupsDaoService(GroupsDao groupsDao) {
        this.groupsDao = groupsDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupsDaoService.class);

    public void create(Groups groups) throws UserInputException {
        groupsDao.create(groups);
    }

    public Optional<Groups> getById(int id) throws Exception {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        return groupsDao.getById(id);
    }

    public void update(Groups groups, int id) throws UserInputException {
        groupsDao.update(groups, id);
    }

    public void delete(int id) throws UserInputException {
        try {
            Integer.parseInt(Integer.toString(id));
        } catch (Exception e) {
            LOGGER.error("Incorrect input {}", UserInputException.class);
            throw new UserInputException();
        }
        groupsDao.delete(id);
    }

    public List<Optional<Groups>> findAll() {
        return groupsDao.findAll();
    }
}
