package com.scalefocus.cvmanager.service;

import com.scalefocus.cvmanager.model.Project;
import com.scalefocus.cvmanager.repository.ProjectRepository;
import com.scalefocus.cvmanager.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectService {

    private ProjectRepository projectRepository;
    private TechnologyRepository technologyRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          TechnologyRepository technologyRepository) {
        this.projectRepository = projectRepository;
        this.technologyRepository = technologyRepository;
    }

    public Optional<Project> getByName(String name) {
        return projectRepository.findByName(name);
    }

    public List<Project> getByTechnology(String technologyName) {
        return projectRepository.getByTechnology(
                technologyRepository.findByName(technologyName));
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project save(Project newEmployee) {
        return projectRepository.save(newEmployee);
    }

    public List<Project> saveAll(List<Project> newEmployee) {
        return projectRepository.saveAll(newEmployee);
    }

    public void deleteProject(String name) {
        projectRepository.deleteByName(name);
    }
}
