package huragan11.cruddemo;

import huragan11.cruddemo.dao.StudentDAO;
import huragan11.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("John", "Doe", "johndoe@gmail.com");
        studentDAO.save(student);
        System.out.println("Student created, saved on id " + student.getId());
    }
}
