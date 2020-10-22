package com.scalefocus.cvmanager.controller;

import com.scalefocus.cvmanager.model.employee.Employee;
import com.scalefocus.cvmanager.service.EmployeeService;
import com.scalefocus.cvmanager.service.ProjectService;
import com.scalefocus.cvmanager.service.TechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ProjectService projectService;
    private final TechnologyService technologyService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              ProjectService projectService,
                              TechnologyService technologyService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.technologyService = technologyService;
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeService.save(newEmployee);
    }

    @PutMapping("/{id}")
    public Optional<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeService.getById(id)
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setMiddleName(newEmployee.getMiddleName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setPhone(newEmployee.getPhone());
                    employee.setManager(newEmployee.getManager());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setPhoto(newEmployee.getPhoto());
                    employee.setManager(newEmployee.getManager());
                    employee.setPosition(newEmployee.getPosition());
                    employee.setDateOfHiring(newEmployee.getDateOfHiring());
                    employee.setStartOfExperience(newEmployee.getStartOfExperience());
                    employee.setCurrentProject(newEmployee.getCurrentProject());
                    employee.setProjects(newEmployee.getProjects());
                    employee.setTechnologies(newEmployee.getTechnologies());
                    employee.setSkills(newEmployee.getSkills());
                    return employeeService.save(newEmployee);
                });
    }

    @DeleteMapping("/{id}")
    public Optional<Employee> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

}
