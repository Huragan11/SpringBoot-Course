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
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
            deleteInstructorDetail(appDAO);

        };
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteInstructorDetailById(id);
        System.out.println("Instructor detail deleted with id " + id);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 2;
        InstructorDetail tempinstructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println(tempinstructorDetail);
        System.out.println(tempinstructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorById(id);
        System.out.println("deleting done");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
    }

    private void createInstructor(AppDAO appDAO) {

        Instructor tempInstructor = new Instructor("John", "Smith", "smithy@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("coding", "link");

        tempInstructor.setInstructorDetail(tempInstructorDetail);
        System.out.println("Instructor created and saved");
        appDAO.save(tempInstructor);
    }
}
