package com.foxminded.jpa;

import com.foxminded.model.Groups;
import com.foxminded.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Integer> {
}
