package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Team;

public interface ManagerDAO {

    String createTeam(Team team);

    Team getTeamById(int teamId);

    void updateTeam(int teamId, Team team);

    String deleteTeam(int teamId);

    boolean removeTeamMember(String employeeId);

    boolean addTeamMember(int teamId, String employeeId);
}
