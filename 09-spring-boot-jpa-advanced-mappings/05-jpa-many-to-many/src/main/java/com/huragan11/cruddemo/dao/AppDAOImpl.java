package com.huragan11.cruddemo.dao;

import com.huragan11.cruddemo.entity.Course;
import com.huragan11.cruddemo.entity.Instructor;
import com.huragan11.cruddemo.entity.InstructorDetail;
import com.huragan11.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<Course> courses = instructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int Id) {
        Course course = entityManager.find(Course.class, Id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.reviews where c.id = :id", Course.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.students where c.id = :id", Course.class);
        query.setParameter("id", id);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int Id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s join fetch s.courses where s.id = :id", Student.class);
        query.setParameter("id", Id);

        return query.getSingleResult();
    }

    @Override
    public InstructorDetail findInstructorDetailById(int Id) {
        return entityManager.find(InstructorDetail.class, Id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int Id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, Id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int Id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", Id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int Id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i join fetch i.courses join fetch i.instructorDetail where i.id = :data", Instructor.class);
        query.setParameter("data", Id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);

    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }
}
