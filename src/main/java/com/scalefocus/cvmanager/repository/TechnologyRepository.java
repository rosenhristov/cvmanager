package com.scalefocus.cvmanager.repository;

import com.scalefocus.cvmanager.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, String> {

    Technology findByName(String technologyName);
    void deleteByName(String name);

}
