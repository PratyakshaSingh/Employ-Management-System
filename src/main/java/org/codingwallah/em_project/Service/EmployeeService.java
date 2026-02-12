package org.codingwallah.em_project.Service;

import java.util.List;

import org.codingwallah.em_project.Controller.Employee;
// import org.springframework.stereotype.Service;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id,Employee employee);
    Employee readEmployee(Long id);
}
