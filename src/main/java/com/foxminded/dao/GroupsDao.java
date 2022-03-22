package com.foxminded.dao;

import com.foxminded.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsDao extends JpaRepository<Groups, Integer> {
}
