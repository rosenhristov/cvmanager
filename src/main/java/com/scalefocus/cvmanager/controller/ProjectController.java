package com.scalefocus.cvmanager.controller;

import com.scalefocus.cvmanager.model.Project;
import com.scalefocus.cvmanager.service.ProjectService;
import com.scalefocus.cvmanager.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;
    private TechnologyService technologyService;

    @Autowired
    public ProjectController(ProjectService projectService, TechnologyService technologyService) {
        this.projectService = projectService;
        this.technologyService = technologyService;
    }

    @GetMapping("/{name}")
    public Project getByName(@PathVariable String projectName) {
        return projectService.getByName(projectName).get();
    }

    @GetMapping("/all")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/tech/{techName}")
    public List<Project> getByTechnology(@PathVariable String techName) {
        return projectService.getByTechnology(techName);
    }

    @PostMapping("/add")
    public Project newEmployee(@RequestBody Project newProject) {
        return projectService.save(newProject);
    }

    @PutMapping("/put/{name}")
    public Project replaceEmployee(@RequestBody Project newProject, @PathVariable String name) {

        return projectService.getByName(name)
                .map(project -> {
                    project.setClient(newProject.getClient());
                    project.setTeamSize(newProject.getTeamSize());
                    project.setStartDate(newProject.getStartDate());
                    project.setEndDate(newProject.getEndDate());
                    project.setResponsibilities(newProject.getResponsibilities());
                    project.setTechnologies(newProject.getTechnologies());
                    return projectService.save(project);
                })
                .orElseGet(() -> {
                    newProject.setName(name);
                    return projectService.save(newProject);
                });
    }

    @DeleteMapping("/del/{name}")
    public void deleteEmployee(@PathVariable String name) {
        projectService.deleteProject(name);
    }
}
