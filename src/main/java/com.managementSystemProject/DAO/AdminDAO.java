package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;

import java.util.List;

public interface AdminDAO {

    List<Employee> getAllEmployees();//TODO DONE

    List<Employee> findEmployeeByFirstName();//TODO DONE

    List<Employee> findEmployeeByLastName(); //TODO DONE

    List<Employee> getEmployeesByDepartment(); //TODO DONE

    Employee getEmployeeById(String employeeId);//TODO DONE

    Manager getManagerById(String employeeId); //TODO DONE

    String addEmployee(Employee employee); //TODO DONE DONE

    void modifyEmployee(String employeeId, Employee employee); //TODO DONE

    String deleteEmployee(String employeeId); //TODO DONE

    String addManager(Manager manager);//TODO DONE

    void modifyManager(String managerId, Manager manager); //TODO DONE

    String deleteManager(String managerId); //TODO DONE

    List<Manager> getAllManagers(); //TODO DONE

    List<Manager> getManagersByDepartment(); //TODO DONE

    List<Manager> getManagerByFirstName(String firstName); //TODO DONE

    List<Manager> getManagerByLastName(String lastName); //TODO DONE

    List<Team> getTeams(); //TODO DONE

}
