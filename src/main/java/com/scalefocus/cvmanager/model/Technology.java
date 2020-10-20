package com.scalefocus.cvmanager.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
public class Technology extends Skill {

    private TechnologyCategory category;

    @Autowired
    public Technology() {
        super();
    }

    public TechnologyCategory getCategory() {
        return category;
    }

    public void setCategory(TechnologyCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Technology{" +
                ", name='" + name + '\'' +
                ", maturity='" + maturity + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                "category=" + category.toString() +
                '}';
    }
}
