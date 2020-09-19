package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;

import java.util.List;

public interface AdminDAO {

    List<Employee> getAllEmployees();

    List<Employee> findEmployeeByFirstName();

    List<Employee> findEmployeeByLastName();

    List<Employee> getEmployeesByDepartment();

    boolean addEmployee(Employee employee);

    void modifyEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void addManager(Manager manager);

    void modifyManager(Manager manager);

    void deleteManager(Manager manager);

    List<Employee> getAllManagers();

}
