package com.scalefocus.cvmanager.repository;

import com.scalefocus.cvmanager.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    default Optional<Employee> removeById(Long id) {
        Optional<Employee> employee = findById(id);
        if (employee.isPresent()) {
            delete(employee.get());
            return employee;
        }
        return Optional.empty();
    }
}
