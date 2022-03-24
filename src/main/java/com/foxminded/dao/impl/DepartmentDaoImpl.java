package com.foxminded.dao.impl;

import com.foxminded.dao.DepartmentDao;
import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Department department) {
        LOGGER.trace("Enter the method");
        LOGGER.debug("Create new department {}", department);
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
        LOGGER.trace("Exit the method");
    }

    @Override
    public Optional<Department> getById(int id) throws DaoException {
        Optional<Department> department = Optional.empty();
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Get department by id {}", id);
            entityManager.getTransaction().begin();
            department = Optional.ofNullable(entityManager.find(Department.class, id));
            entityManager.getTransaction().commit();
            if (!department.isPresent()) {
                LOGGER.error("This Department is empty {}", DaoException.class);
                throw  new DaoException();
            }
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return department;
    }

    @Override
    public void update(Department department) {
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Update this department {}", department);
            entityManager.merge(department);
            LOGGER.trace("Exit the method");
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(int id) {
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Delete department by id {}", id);
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Department.class, id));
            entityManager.getTransaction().commit();
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Department> findAll() {
        List<Department> department = null;
        try {
            LOGGER.trace("Enter the method");
            LOGGER.debug("Get list Departments");
            department = entityManager.createQuery("from Department", Department.class).getResultList();
            LOGGER.trace("Exit the method");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return department;
    }
}
