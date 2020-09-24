package com.managementSystemProject.Model;

import com.managementSystemProject.Generator.IDGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "id")
    private String teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_description")
    private String teamDescription;

    @Column(name = "created")
    private LocalDate createdOn;

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public Team() {
        this.teamId = "T" + IDGenerator.randomId();
    }

    @Column(name = "team_leader")
    private String teamLeader;

    public List<TeamMapper> getTeamMappers() {
        return teamMappers;
    }

    public void setTeamMappers(List<TeamMapper> teamMappers) {
        this.teamMappers = teamMappers;
    }

    @OneToMany(targetEntity = TeamMapper.class, mappedBy = "team")
    @Access(AccessType.PROPERTY)
    private List<TeamMapper> teamMappers;

    public String randomizeTeamId() {
        return this.teamId = "TMA" + IDGenerator.randomId();
    }


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }
}
