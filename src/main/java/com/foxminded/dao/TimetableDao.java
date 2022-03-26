package com.foxminded.dao;


import com.foxminded.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimetableDao extends JpaRepository<Timetable, Integer> {
    List<Timetable> findTimetablesByTeacherIdOrCourseIdOrDateOrGroupsId(Integer teacherId, Integer courseId, LocalDate date, Integer groupsId);
}
