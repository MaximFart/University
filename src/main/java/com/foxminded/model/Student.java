package com.foxminded.model;

import java.util.Objects;

public class Student extends Person {
    private int id;
    private int groupsId;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, int timetableId, int id, int groupsId) {
        super(firstName, lastName, age, timetableId);
        this.id = id;
        this.groupsId = groupsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(int groupsId) {
        this.groupsId = groupsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(groupsId, student.groupsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, groupsId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", timetable=" + getTimetableId() +
                "id=" + id +
                ", groups=" + groupsId +
                '}';
    }
}
