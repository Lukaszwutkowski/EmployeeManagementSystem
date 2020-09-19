package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class AdminDAOImpl implements AdminDAO {

    Scanner scanner = new Scanner(System.in);

    private EntityManager em;

    private void createEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private void closeEntityManager(){
        em.close();
    }

    @Override
    public List<Employee> getAllEmployees() {
        createEntityManager();
        TypedQuery<Employee> employeeTypedQuery = em.createQuery("select s from employees s", Employee.class);
        List<Employee> resultList = employeeTypedQuery.getResultList();
        closeEntityManager();
        return resultList ;
    }

    @Override
    public List<Employee> findEmployeeByFirstName() {
        TypedQuery<Employee> byFirstName = em.createNamedQuery(Employee.BY_FIRST_NAME, Employee.class);
        String firstNameTmp = scanner.next();
        byFirstName.setParameter("firstName", firstNameTmp);
        List<Employee> resultList = byFirstName.getResultList();
        return resultList;
    }

    @Override
    public List<Employee> findEmployeeByLastName() {
        TypedQuery<Employee> byLastName = em.createNamedQuery(Employee.BY_LAST_NAME, Employee.class);
        String lastNameTmp = scanner.next();
        byLastName.setParameter("lastName", lastNameTmp);
        List<Employee> resultList = byLastName.getResultList();
        return resultList;
    }

    @Override
    public List<Employee> getEmployeesByDepartment() {
        createEntityManager();
        String departmentTmp = scanner.next();
        TypedQuery<Employee> employeeTypedQuery = em.createQuery("select e from employees e where  = " + departmentTmp, Employee.class);
        List<Employee> resultList = employeeTypedQuery.getResultList();
        closeEntityManager();
        return resultList;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        createEntityManager();
        TypedQuery<Employee> employeeTypedQuery = em.createQuery("insert into employees(first_name, last_name, birth_date, street, city, zip_code, email, department, salary, hire_date) values('%s', '%s', '%s')\" ")

    }

    @Override
    public void modifyEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public void addManager(Manager manager) {

    }

    @Override
    public void modifyManager(Manager manager) {

    }

    @Override
    public void deleteManager(Manager manager) {

    }

    @Override
    public List<Employee> getAllManagers() {
        return null;
    }
}
