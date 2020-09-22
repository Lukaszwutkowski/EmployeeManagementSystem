package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;

import java.util.List;

public interface TeamMapperDAO {

    boolean createTeamLeader(Team team);

    Manager getLeader(int teamId);

    List<Employee> getTeamMembers(String teamId);

    List<Employee> listAvaibleEmployees();

    boolean removeTeamMember(String employeeId);

    boolean addTeamMember(int teamId, String employeeId);
}

