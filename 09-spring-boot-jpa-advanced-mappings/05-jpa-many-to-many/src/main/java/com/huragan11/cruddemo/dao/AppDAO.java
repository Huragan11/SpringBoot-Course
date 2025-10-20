package com.huragan11.cruddemo.dao;

import com.huragan11.cruddemo.entity.Course;
import com.huragan11.cruddemo.entity.Instructor;
import com.huragan11.cruddemo.entity.InstructorDetail;
import com.huragan11.cruddemo.entity.Student;

import java.time.chrono.MinguoDate;
import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int Id);

    void deleteInstructorById(int Id);

    InstructorDetail findInstructorDetailById(int Id);

    void deleteInstructorDetailById(int Id);

    List<Course> findCoursesByInstructorId(int Id);

    Instructor findInstructorByIdJoinFetch(int Id);

    void updateInstructor(Instructor theInstructor);

    void update(Course theCourse);

    Course findCourseById(int id);

    void deleteCourseById(int Id);

    void saveCourse(Course theCourse);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int Id);

}
