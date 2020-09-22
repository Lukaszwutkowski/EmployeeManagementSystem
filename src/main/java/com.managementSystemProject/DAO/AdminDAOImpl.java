package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AdminDAOImpl implements AdminDAO {

    private static Logger log = Logger.getLogger(String.valueOf(AdminDAOImpl.class));

    private TeamMapperDAO teamMapperDAO;

    String message = "error";

    Scanner scanner = new Scanner(System.in);

    private EntityManager em;

    private void createEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private void closeEntityManager() {
        em.close();
    }

    @Override
    public List<Employee> getAllEmployees() {
        createEntityManager();
        TypedQuery<Employee> employeeTypedQuery = em.createQuery("select s from employees ", Employee.class);
        List<Employee> resultList = employeeTypedQuery.getResultList();
        closeEntityManager();
        return resultList;
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
    public Employee getEmployeeById(String employeeId) {
        createEntityManager();
        em.getTransaction().begin();
        log.info("inside getEmployeeById methode");
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employees e WHERE e.employeeId = '" + employeeId + "'", Employee.class);
        List<Employee> resultList = query.getResultList();
        em.getTransaction().commit();
        closeEntityManager();
        return resultList.get(0);
    }

    @Override
    public Manager getManagerById(String managerId) {
        createEntityManager();
        em.getTransaction().begin();
        log.info("inside getManagerById methode");
        TypedQuery<Manager> query = em.createQuery("SELECT m FROM Manager m WHERE e.managerId = '" + managerId + "'", Manager.class);
        List<Manager> resultList = query.getResultList();
        em.getTransaction().commit();
        closeEntityManager();
        return resultList.get(0);
    }

    @Override
    public String addEmployee(Employee employee) {
       /* String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int birthYear = scanner.nextInt();
        int birthMonth = scanner.nextInt();
        int birthDay = scanner.nextInt();
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        String street = scanner.nextLine();
        String city = scanner.nextLine();
        String zipCode = scanner.nextLine();
        String email = scanner.nextLine();
        String department = scanner.nextLine();
        BigDecimal salary = BigDecimal.valueOf(5789);
        int hireYear = 2020;
        int hireMonth = 04;
        int hireDay = 12;
        LocalDate hireDate = LocalDate.of(hireYear, hireMonth, hireDay);
        //TypedQuery<Employee> employeeTypedQuery = em.createQuery("insert into person(first_name, last_name, birth_date) values('%s', '%s', '%s')"),
        Employee employee = new Employee(firstName, lastName, birthDate, street, city, zipCode, email, department, salary, hireDate);

        */
        createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        if (!employee.getEmployeeId().equals(null)) {
            message = "Employee Successfully Created.";
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }

    @Override
    public void modifyEmployee(String employeeId, Employee employee) {
        createEntityManager();
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, employeeId);
        em.merge(e);
        message = "Employee record updated successfully.";
        em.getTransaction().commit();
        closeEntityManager();
    }

    @Override
    public String addManager(Manager manager) {

        createEntityManager();
        em.getTransaction().begin();
        em.persist(manager);
        if (!manager.getManagerId().equals(null)) {
            message = "Manager Successfully Created.";
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }

    @Override
    public void modifyManager(String managerId, Manager manager) {
        createEntityManager();
        em.getTransaction().begin();
        Manager m = em.find(Manager.class, managerId);
        em.merge(m);
        message = "Manager record updated successfully.";
        em.getTransaction().commit();
        closeEntityManager();
    }

    @Override
    public String deleteManager(String managerId) {
        createEntityManager();
        em.getTransaction().begin();
        try {
            Manager m = em.find(Manager.class, managerId);
            em.remove(m);
            message = "Manager record removed successfully.";
        } catch (Exception e) {
            log.info("" + e.getStackTrace());
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;

    }

    public String deleteEmployee(String employeeId) {
        createEntityManager();
        em.getTransaction().begin();
        try {
            Employee e = em.find(Employee.class, employeeId);
            em.remove(e);
            message = "Employee record removed successfully.";
        } catch (Exception e) {
            log.info("" + e.getStackTrace());
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }

    @Override
    public List<Manager> getAllManagers() {
        createEntityManager();
        TypedQuery<Manager> managerTypedQuery = em.createQuery("select m from Manager", Manager.class);
        List<Manager> resultList = managerTypedQuery.getResultList();
        closeEntityManager();
        return resultList;
    }

    @Override
    public List<Manager> getManagersByDepartment() {
        createEntityManager();
        String departmentTmp = scanner.next();
        TypedQuery<Manager> managerTypedQuery = em.createQuery("select m from Manager m where  = " + departmentTmp, Manager.class);
        List<Manager> resultList = managerTypedQuery.getResultList();
        closeEntityManager();
        return resultList;
    }

    @Override
    public List<Manager> getManagerByFirstName(String firstName) {
        return getAllManagers()
                .stream()
                .filter(x -> x.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Manager> getManagerByLastName(String lastName) {
        return getAllManagers()
                .stream()
                .filter(x -> x.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeams() {
            createEntityManager();
            em.getTransaction().begin();
            List<Team> teams = em.createQuery("SELECT t FROM Team t Order By t.createdOn DESC",Team.class).getResultList();
        for (Team team: teams) {
            Manager manager = teamMapperDAO.getLeader(team.getTeamId());
            team.setTeamLeader(manager.getFirstName()+" "+manager.getLastName()+" ["+manager.getManagerId()+"]"); }
            em.getTransaction().commit();
            closeEntityManager();
            return teams;
           }


}
