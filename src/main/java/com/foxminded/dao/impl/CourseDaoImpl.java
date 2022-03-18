package com.foxminded.dao.impl;

import com.foxminded.dao.CourseDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDaoImpl.class);

//    @PersistenceUnit
//    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Course course) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Add new course {}", course);
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        LOGGER.trace("Exit from method");
    }

    @Override
    public Optional<Course> getById(int id) throws DaoException {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get course by id {}", id);
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Optional<Course> course = Optional.of(entityManager.find(Course.class, id));
        entityManager.close();
        if (!course.isPresent()) {
            LOGGER.error("This course is empty {}", DaoException.class);
            throw new DaoException();
        }
        LOGGER.trace("Exit the method");
        return course;
    }

    @Override
    public void update(Course course) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Update this course {}", course);
        LOGGER.trace("Exit the method");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Delete course by id {}", id);
        LOGGER.trace("Exit the method");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Course> findAll() {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Get list courses");
        LOGGER.trace("Exit the method");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Course> courses = entityManager.createQuery("Select c from Course c", Course.class).getResultList();
        entityManager.close();
        return courses;
    }
}
