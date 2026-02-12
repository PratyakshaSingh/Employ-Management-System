package org.codingwallah.em_project.Service;
import java.util.ArrayList;
import java.util.List;
import org.codingwallah.em_project.Controller.Employee;
import org.codingwallah.em_project.Entity.EmployeeEntity;
import org.codingwallah.em_project.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeSeviceImp implements EmployeeService{
@Autowired
private EmployeeRepository employeeRepository;
List<Employee> employees=new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        // employees.add(employee);
            return "Saved Successfully";
    }
    // @Override
    // public Employee readEmployee(Long id){
    //     EmployeeEntity emp=employeeRepository.findById(id).get();
    //     Employee employee=new Employee();
    //     BeanUtils.copyProperties(employeeEntity,employee);
    //     return employee;
    // }
        
    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList=employeeRepository.findAll();
        List<Employee> employees=new ArrayList<>();
        for(EmployeeEntity employeeEntity:employeeList)
        {
            Employee emp=new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
    //    employees.remove(id);
    EmployeeEntity emp=employeeRepository.findById(id).get();
    employeeRepository.delete(emp);
       return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity exsistingEmployee=employeeRepository.findById(id).get();
        exsistingEmployee.setEmail(employee.getEmail());
        exsistingEmployee.setPhone(employee.getPhone());
        exsistingEmployee.setName(employee.getName());
        employeeRepository.save(exsistingEmployee);
       return "Update successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readEmployee'");
    }

}
