package com.managementSystemProject.Model;

import com.managementSystemProject.Generator.IDGenerator;

import javax.persistence.*;

@Entity
@Table(name = "team_mapp")
public class TeamMapper {

    @Id
    @Column(name = "id")
    private String mapperId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empRefId")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "managerRefId")
    private Manager manager;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamRefId")
    private Team team;

    @Transient
    private boolean isLeader;

    @Transient
    private boolean isAssigned;

    public Manager getManager() {
        return manager;
    }

    public String randomizeTeamMapperId() {
        return this.mapperId = "MAP" + IDGenerator.randomId();
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getMapperId() {
        return mapperId;
    }

    public void setMapperId(String mapperId) {
        this.mapperId = mapperId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public TeamMapper() {
        this.mapperId = "TM" + IDGenerator.randomId();
    }
}
