package com.scalefocus.cvmanager.controller;

import com.scalefocus.cvmanager.model.Technology;
import com.scalefocus.cvmanager.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private TechnologyService service;

    @Autowired
    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public Technology getByName(@PathVariable String name) {
        return service.getByName(name).get();
    }

    @GetMapping("/all")
    public List<Technology> getAll() {
        return service.getAll();
    }

    @PostMapping("/add")
    public Technology addTechnology(@RequestBody Technology newTech) {
        return service.save(newTech);
    }

    @PutMapping("/put/{name}")
    public Technology replaceEmployee(@RequestBody Technology newTech, @PathVariable String name) {

        return service.getByName(name)
                .map(tech -> {
                    tech.setName(newTech.getName());
                    tech.setMaturity(newTech.getMaturity());
                    tech.setYearsOfExperience(newTech.getYearsOfExperience());
                    tech.setCategory(newTech.getCategory());
                    return service.save(tech);
                })
                .orElseGet(() -> {
                    newTech.setName(name);
                    return service.save(newTech);
                });
    }

    @DeleteMapping("/del/{name}")
    public void deleteTechnology(@PathVariable String name) {
        service.deleteTechnology(name);
    }

}
