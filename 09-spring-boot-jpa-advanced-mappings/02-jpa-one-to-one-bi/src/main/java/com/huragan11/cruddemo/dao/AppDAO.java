package com.huragan11.cruddemo.dao;

import com.huragan11.cruddemo.entity.Instructor;
import com.huragan11.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int Id);

    void deleteInstructorById(int Id);

    InstructorDetail findInstructorDetailById(int Id);
}
