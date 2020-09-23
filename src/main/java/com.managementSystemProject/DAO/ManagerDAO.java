package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Team;

public interface ManagerDAO {

    String createTeam(Team team);

    Team getTeamById(String teamId);

    void updateTeam(String teamId, Team team);

    String deleteTeam(String teamId);

    boolean removeTeamMember(String employeeId);

    boolean addTeamMember(String teamId, String employeeId);
}
