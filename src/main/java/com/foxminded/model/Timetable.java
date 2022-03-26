package com.foxminded.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "groups_id")
    private Integer groupsId;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "course_id")
    private Integer courseId;

    public Timetable() {
    }

    public Timetable(Integer id, LocalDate date, Integer groupsId, Integer teacherId, Integer courseId) {
        this.id = id;
        this.date = date;
        this.groupsId = groupsId;
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(Integer groupsId) {
        this.groupsId = groupsId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(date, timetable.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "date=" + date +
                ", groups=" + groupsId +
                ", teacherId=" + teacherId +
                ", course=" + courseId +
                '}';
    }
}
