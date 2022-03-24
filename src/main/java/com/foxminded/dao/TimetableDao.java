package com.foxminded.dao;


import com.foxminded.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableDao extends JpaRepository<Timetable, Integer> {
}
