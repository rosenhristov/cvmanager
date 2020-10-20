package com.scalefocus.cvmanager.model.employee;

import com.google.common.collect.Multimap;
import com.scalefocus.cvmanager.model.Adress;
import com.scalefocus.cvmanager.model.Project;
import com.scalefocus.cvmanager.model.Skill;
import com.scalefocus.cvmanager.model.TechnologyCategory;
import com.scalefocus.cvmanager.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
public class Employee {

    protected @Id @GeneratedValue Long id;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String phone;
    @OneToMany
    protected Adress address;
    protected String photo;
    @OneToMany
    protected DirectManager manager;
    protected String position;
    protected Date dateOfHiring;
    protected Date startOfExperience;
    private String currentProject;
    @ManyToMany
    private List<Project> projects;
    @ManyToMany
    protected Multimap<TechnologyCategory, String> technologies;
    @OneToMany
    protected List<Skill> skills;

    @Autowired
    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(java.lang.String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return new StringBuilder(firstName).append(' ')
                        .append(middleName).append(' ')
                        .append(lastName)
                        .toString();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public Adress getAddress() {
        return address;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public DirectManager getManager() {
        return manager;
    }

    @Autowired
    public void setManager(DirectManager manager) {
        this.manager = manager;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(java.lang.String position) {
        this.position = position;
    }

    public Date getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(Date dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public Date getStartOfExperience() {
        return startOfExperience;
    }

    public void setDateOfInitiаlEmployment(Date dateOfInitialEmployment) {
        this.startOfExperience = dateOfInitialEmployment;
    }

    public void setStartOfExperience(Date startOfExperience) {
        this.startOfExperience = startOfExperience;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Multimap<TechnologyCategory, String> getTechnologies() {
        return this.technologies;
    }


    public void setTechnologies(Multimap<TechnologyCategory, String> technologies) {
        this.technologies = technologies;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Autowired
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getYearsOfExperience() {
        return  LocalDate.now().getYear() - Utils.toLocalDate(startOfExperience).getYear();
    }

    public int getYearsOnPosition() {
        return  LocalDate.now().getYear() - Utils.toLocalDate(dateOfHiring).getYear();
    }

    public boolean isManager() {
        return false;
    }

    public boolean isAdministrator() {
        return false;
    }

    @Override
    public java.lang.String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address.toString() +
                ", photo=" + photo +
                ", manager=" + manager +
                ", position='" + position + '\'' +
                ", dateOfHiring=" + dateOfHiring +
                ", startOfExperience=" + startOfExperience +
                '}';
    }
}
