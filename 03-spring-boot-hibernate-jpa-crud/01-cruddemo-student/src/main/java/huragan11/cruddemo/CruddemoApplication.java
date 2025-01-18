package huragan11.cruddemo;

import huragan11.cruddemo.dao.StudentDAO;
import huragan11.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

            updateStudent(studentDAO);

        };

    }

    private void updateStudent(StudentDAO studentDAO) {
        Student temp = studentDAO.findById(1);

        temp.setFirstName("Scooby");

        studentDAO.update(temp);

        System.out.println(temp);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findByLastName("Smith");

        for (Student student : theStudents) {
            System.out.println(student);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = new Student("John", "Smith", "johnsmith@gmail.com");
        studentDAO.save(student);

        int id = student.getId();

        Student myStudent = studentDAO.findById(id);

        System.out.println("found student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student student1 = new Student("Paul", "Doe", "paul@gmail.com");
        Student student2 = new Student("Aaron", "Smith", "aaron@gmail.com");
        Student student3 = new Student("Jane", "Boe", "jane@gmail.com");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("John", "Doe", "johndoe@gmail.com");
        studentDAO.save(student);
    }
}
