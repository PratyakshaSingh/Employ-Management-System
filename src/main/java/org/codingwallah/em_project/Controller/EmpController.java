package org.codingwallah.em_project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.codingwallah.em_project.Service.EmployeeService;
import org.codingwallah.em_project.Service.EmployeeSeviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class EmpController { 
 // List<Employee> employees=new ArrayList<>();
 @Autowired
 EmployeeService employeeService;
   
  @GetMapping("employees")  
  public List<Employee> getAllEmployees()
    {
        return employeeService.readEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee getEmployeesById(@PathVariable Long id)
    {
        System.out.println("Yes mai aa rha hu");
        return employeeService.readEmployee(id);
    }
    
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
        // return "Saved Sucessfully";
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        if(employeeService.deleteEmployee(id))
        {
        return "Delete Sucessfully";
        }
     
        return "Not found";
    }
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        //TODO: process PUT request
        
        return employeeService.updateEmployee(id, employee);
    }
}
