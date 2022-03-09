package com.foxminded.model;

import java.util.Objects;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private int timetableId;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, int timetableId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.timetableId = timetableId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName) && Objects.equals(timetableId, person.timetableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
