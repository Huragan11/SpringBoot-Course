package com.huragan11.cruddemo;

import com.huragan11.cruddemo.dao.AppDAO;
import com.huragan11.cruddemo.entity.Instructor;
import com.huragan11.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {

        Instructor tempInstructor = new Instructor("John", "Smith", "smithy@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("coding", "link");

        tempInstructor.setInstructorDetail(tempInstructorDetail);
        System.out.println("Instructor created and saved");
        appDAO.save(tempInstructor);
    }
}
