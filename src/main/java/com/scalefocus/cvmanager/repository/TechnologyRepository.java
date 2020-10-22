package com.scalefocus.cvmanager.repository;

import com.scalefocus.cvmanager.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnologyRepository extends JpaRepository<Technology, String> {

    Technology findByName(String technologyName);
    Technology deleteByName(String name);
    default Optional<Technology> remove (String name) {
        Optional<Technology> technology = findById(name);
        if (technology.isPresent()) {
            delete(technology.get());
            return technology;
        }
        return Optional.empty();
    }

}
