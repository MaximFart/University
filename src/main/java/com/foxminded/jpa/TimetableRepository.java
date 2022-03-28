package com.foxminded.jpa;

import com.foxminded.model.Groups;
import com.foxminded.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
    List<Timetable> findTimetablesByTeacherIdOrCourseIdOrDateOrGroupsId(int teacherId, int courseId, LocalDate date, int groupsId);
}

