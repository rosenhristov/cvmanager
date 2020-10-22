package com.scalefocus.cvmanager.controller;

import com.scalefocus.cvmanager.model.Project;
import com.scalefocus.cvmanager.service.ProjectService;
import com.scalefocus.cvmanager.service.TechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final TechnologyService technologyService;

    @Autowired
    public ProjectController(ProjectService projectService,
                             TechnologyService technologyService) {
        this.projectService = projectService;
        this.technologyService = technologyService;
    }

    @GetMapping("/{name}")
    public Project getByName(@PathVariable String projectName) {
        return projectService.getByName(projectName).get();
    }

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @PostMapping
    public Project newEmployee(@RequestBody Project newProject) {
        return projectService.save(newProject);
    }

    @PutMapping("/{name}")
    public Optional<Project> replaceEmployee(@RequestBody Project newProject, @PathVariable String name) {
        return projectService.getByName(name)
                .map(project -> {
                    project.setClient(newProject.getClient());
                    project.setTeamSize(newProject.getTeamSize());
                    project.setStartDate(newProject.getStartDate());
                    project.setEndDate(newProject.getEndDate());
                    project.setResponsibilities(newProject.getResponsibilities());
                    project.setTechnologies(newProject.getTechnologies());
                    return projectService.save(project);
                });
    }

    @DeleteMapping("/{name}")
    public Optional<Project> deleteEmployee(@PathVariable String name) {
        return projectService.deleteProject(name);
    }
}
