package com.scalefocus.cvmanager.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class Skill {

    @Id
    protected String name;
    protected String maturity;
    protected int yearsOfExperience;

    @Autowired
    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", maturity='" + maturity + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
