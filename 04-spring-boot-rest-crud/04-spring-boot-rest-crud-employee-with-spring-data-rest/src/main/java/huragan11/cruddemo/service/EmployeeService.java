package huragan11.cruddemo.service;

import huragan11.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

   List<Employee> findAll();

   Employee findById(int id);

   Employee save(Employee employee);

   void deleteById(int id);

}
