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

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Course course) {
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Add new course {}", course);
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            LOGGER.trace("Exit fromm  method");
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Course> getById(int id) throws DaoException {
        Optional<Course> course = Optional.empty();
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Get course by id {}", id);
            entityManager.getTransaction().begin();
            course = Optional.ofNullable(entityManager.find(Course.class, id));
            entityManager.getTransaction().commit();
            if (!course.isPresent()) {
                LOGGER.error("This course is empty {}", DaoException.class);
                throw new DaoException();
            }
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return course;
    }

    @Override
    public void update(Course course) {

        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Update this course {}", course);
            entityManager.getTransaction().begin();
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(int id) {
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Delete course by id {}", id);
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Course.class, id));
            entityManager.getTransaction().commit();
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = null;
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Get list courses");
            courses = entityManager.createQuery("from Course", Course.class).getResultList();
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return courses;
    }
}
