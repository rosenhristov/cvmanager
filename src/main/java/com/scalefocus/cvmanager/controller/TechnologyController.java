package com.scalefocus.cvmanager.controller;

import com.scalefocus.cvmanager.model.Technology;
import com.scalefocus.cvmanager.service.TechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final TechnologyService service;

    @Autowired
    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public Technology getByName(@PathVariable String name) {
        return service.getByName(name).get();
    }

    @GetMapping
    public List<Technology> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Technology addTechnology(@RequestBody Technology newTech) {
        return service.save(newTech);
    }

    @PutMapping("/{name}")
    public Optional<Technology> replaceEmployee(@RequestBody Technology newTech, @PathVariable String name) {
        return service.getByName(name)
                .map(tech -> {
                    tech.setName(newTech.getName());
                    tech.setMaturity(newTech.getMaturity());
                    tech.setYearsOfExperience(newTech.getYearsOfExperience());
                    tech.setCategory(newTech.getCategory());
                    return service.save(tech);
                });
    }

    @DeleteMapping("/{name}")
    public Optional<Technology> deleteTechnology(@PathVariable String name) {
        return service.deleteTechnology(name);
    }

}
