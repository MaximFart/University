package com.foxminded.service;

import com.foxminded.jpa.TimetableRepository;
import com.foxminded.model.Timetable;
import com.foxminded.service.exception.UserInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimetableDaoService {

    private final TimetableRepository timetableRepository;

    @Autowired
    public TimetableDaoService(TimetableRepository timetableDao) {
        this.timetableRepository = timetableDao;
    }

    public void create(Timetable timetable) throws UserInputException {
        timetableRepository.save(timetable);
    }

    public Optional<Timetable> getById(int id) {
        return timetableRepository.findById(id);
    }

    public void update(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    public void delete(int id) {
        timetableRepository.deleteById(id);
    }

    public List<Timetable> findTimetablesByTeacherIdOrCourseIdOrDateOrGroupsId(int teacherId, int courseId, LocalDate date, int groupsId) {
        return timetableRepository.findTimetablesByTeacherIdOrCourseIdOrDateOrGroupsId(teacherId, courseId, date, groupsId);
    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }
}
