package com.foxminded.service;

import com.foxminded.jpa.GroupsRepository;
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
    private GroupsRepository groupsDao;

    public void create(Groups groups) throws UserInputException {
        groupsDao.save(groups);
    }

    public Optional<Groups> getById(int id) throws Exception {
        return groupsDao.findById(id);
    }

    public void update(Groups groups) throws UserInputException, Exception {
        groupsDao.save(groups);
    }

    public void delete(int id) throws UserInputException {
        groupsDao.deleteById(id);
    }

    public List<Groups> findAll() {
        return groupsDao.findAll();
    }
}
