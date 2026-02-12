package org.codingwallah.em_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.codingwallah.em_project.Entity.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{

    EmployeeEntity save(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAll();
    
}
