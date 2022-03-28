package com.foxminded.jpa;

import com.foxminded.model.Groups;
import com.foxminded.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
