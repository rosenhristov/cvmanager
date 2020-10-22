package com.scalefocus.cvmanager.service;

import com.scalefocus.cvmanager.model.employee.Employee;
import com.scalefocus.cvmanager.repository.EmployeeRepository;
import com.scalefocus.cvmanager.repository.ProjectRepository;
import com.scalefocus.cvmanager.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;
    private TechnologyRepository technologyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository,
                           TechnologyRepository technologyRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.technologyRepository = technologyRepository;
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> getByCurrentProject(String projectName) {
        return  employeeRepository.findAll().stream()
                    .filter(employee -> employee.getCurrentProject().equals(projectName))
                    .collect(Collectors.toList());
    }

    public List<Employee> getByProjectHistory(String projectName) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getProjects().contains(projectName))
                .collect(Collectors.toList());
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAll(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public Optional<Employee> deleteEmployee(Long id) {
        return employeeRepository.removeById(id);
    }
}
