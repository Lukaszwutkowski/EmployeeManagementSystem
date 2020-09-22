package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;

import java.util.List;

public interface AdminDAO {

    List<Employee> getAllEmployees();

    List<Employee> findEmployeeByFirstName();

    List<Employee> findEmployeeByLastName();

    List<Employee> getEmployeesByDepartment();

    Employee getEmployeeById(String employeeId);

    Manager getManagerById(String employeeId);

    String addEmployee(Employee employee);

    void modifyEmployee(String employeeId, Employee employee);

    String deleteEmployee(String employeeId);

    String addManager(Manager manager);

    void modifyManager(String managerId, Manager manager);

    String deleteManager(String managerId);

    List<Manager> getAllManagers();

    List<Manager> getManagersByDepartment();

    List<Manager> getManagerByFirstName(String firstName);

    List<Manager> getManagerByLastName(String lastName);

    List<Team> getTeams();

}
