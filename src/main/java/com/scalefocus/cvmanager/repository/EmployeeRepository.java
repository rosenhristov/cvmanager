package com.scalefocus.cvmanager.repository;

import com.scalefocus.cvmanager.model.Technology;
import com.scalefocus.cvmanager.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByProject(String projectName);
    List<Employee> findByTechnology(Technology technologyName);
}
