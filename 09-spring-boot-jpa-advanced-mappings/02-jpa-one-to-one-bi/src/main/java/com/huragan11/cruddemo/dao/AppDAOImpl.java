package com.huragan11.cruddemo.dao;

import com.huragan11.cruddemo.entity.Instructor;
import com.huragan11.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int Id) {
        return entityManager.find(Instructor.class, Id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int Id) {
        Instructor instructor = entityManager.find(Instructor.class, Id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int Id) {
        return entityManager.find(InstructorDetail.class, Id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int Id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, Id);
        entityManager.remove(instructorDetail);
    }
}
