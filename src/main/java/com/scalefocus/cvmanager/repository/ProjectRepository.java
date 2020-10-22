package com.scalefocus.cvmanager.repository;

import com.scalefocus.cvmanager.model.Project;
import com.scalefocus.cvmanager.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String> {

    Optional<Project> findByName(String projectName);
    List<Project> getByTechnology(Technology technology);
    default Optional<Project> remove(String name) {
        Optional<Project> project = findByName(name);
        if (project.isPresent()) {
            delete(project.get());
            return project;
        }
        return Optional.empty();
    }

}
