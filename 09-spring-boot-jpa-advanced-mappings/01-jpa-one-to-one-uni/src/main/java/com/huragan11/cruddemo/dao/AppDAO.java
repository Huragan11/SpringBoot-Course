package com.huragan11.cruddemo.dao;

import com.huragan11.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int Id);


}
