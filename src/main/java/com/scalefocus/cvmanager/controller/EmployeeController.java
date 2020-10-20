package com.scalefocus.cvmanager.controller;

import com.scalefocus.cvmanager.model.employee.Employee;
import com.scalefocus.cvmanager.service.EmployeeService;
import com.scalefocus.cvmanager.service.ProjectService;
import com.scalefocus.cvmanager.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private ProjectService projectService;
    private TechnologyService technologyService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ProjectService projectService,
                              TechnologyService technologyService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.technologyService = technologyService;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getById(id).get();
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


    @GetMapping("/proj/{projectName}")
    public List<Employee> getByProject(@PathVariable String projectName) {
        return employeeService.getByProject(projectName);
    }

    @GetMapping("/proj-history/{projectName}")
    public List<Employee> getByProjectHistory(@PathVariable String projectName) {
        return employeeService.getByProjectHistory(projectName);
    }

    @GetMapping("/tech/{technologyName}")
    public List<Employee> getByTechnology(@PathVariable String technologyName) {
        return employeeService.getByTechnology(technologyName);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeService.save(newEmployee);
    }

    @PutMapping("/replace/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

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
                    return employeeService.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeService.save(newEmployee);
                });
    }

    @DeleteMapping("/del/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
