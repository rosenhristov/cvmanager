package com.scalefocus.cvmanager.model.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Entity
@AllArgsConstructor
public class DirectManager extends Employee {

    @OneToMany
    protected List<Employee> team;

    @Autowired
    public DirectManager() {
        super();
    }

    public List<Employee> getTeam() {
        if (team == null) {
            team = new LinkedList<>();
        }
        return team;
    }

    @Autowired
    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    public boolean addTeamMember(Employee employee) {
        return getTeam().add(employee);
    }

    public boolean removeTeamMember(Employee employee) {
        return getTeam().remove(employee);
    }

    public boolean isManagerOf(Employee employee) {
        return getTeam().contains(employee);
    }

    @Override
    public boolean isManager() {
        return true;
    }

    @Override
    public boolean isAdministrator() {
        return false;
    }

    @Override
    public java.lang.String toString() {
        return "DirectManager{" +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", photo='" + photo + '\'' +
                ", manager=" + manager +
                ", position='" + position + '\'' +
                ", dateOfHiring=" + dateOfHiring +
                ", dateOfHiring=" + dateOfHiring +
                "team=" + Arrays.toString(getTeam().toArray()) +
                '}';
    }
}
