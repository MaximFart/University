package com.foxminded.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups")
public class Groups {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Timetable> timetables = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Student> students = new ArrayList<>();

    public Groups() {
    }

    public Groups(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groups groups = (Groups) o;
        return id == groups.id && Objects.equals(name, groups.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
