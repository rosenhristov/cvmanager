package com.scalefocus.cvmanager.model.employee;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@Entity
public class Administrator extends Employee {

    @Autowired
    public Administrator() {
        super();
    }

    @Override
    public boolean isManager() {
        return false;
    }

    @Override
    public boolean isAdministrator() {
        return true;
    }
}
