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
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "groups_id")
    private int groupsId;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "course_id")
    private int courseId;

    public Timetable() {
    }

    public Timetable(int id, LocalDate date, int groupsId, int teacherId, int courseId) {
        this.id = id;
        this.date = date;
        this.groupsId = groupsId;
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(int groupsId) {
        this.groupsId = groupsId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
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
