package com.scalefocus.cvmanager.service;

import com.scalefocus.cvmanager.model.Technology;
import com.scalefocus.cvmanager.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TechnologyService {

    private TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public Optional<Technology> getByName(String techName) {
        return Optional.of(technologyRepository.findByName(techName));
    }

    public List<Technology> getAll() {
        return technologyRepository.findAll();
    }

    public Technology save(Technology tech) {
        return technologyRepository.save(tech);
    }

    public List<Technology> saveAll(List<Technology> techList) {
         return technologyRepository.saveAll(techList);
    }

    public void deleteTechnology(String name) {
        technologyRepository.deleteByName(name);
    }
}
