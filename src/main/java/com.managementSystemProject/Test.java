package com.managementSystemProject;

import com.managementSystemProject.DAO.AdminDAOImpl;
import com.managementSystemProject.DAO.ManagerDAOImpl;
import com.managementSystemProject.DAO.TeamMapperDAOImpl;
import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Test {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setEmployeeId(employee.randomizeEmployeeId());
        employee.setFirstName("Lukasz");
        employee.setLastName("Mocny");
        employee.setStreet("Bulonska 23/4");
        employee.setZipCode("80-288");
        employee.setCity("Gdansk");
        employee.setPhoneNumber(3457684);
        employee.setBirthDate(LocalDate.of(1986,03,23));
        employee.setDepartment("Technologia");
        employee.setPosition("Informatyk");
        employee.setSalary(BigDecimal.valueOf(7600));
        employee.setHireDate(LocalDate.of(2020, 03,01));
        employee.setEmployeeId(employee.emailGeneratorForEmployee());


        Manager manager = new Manager();
        manager.setManagerId(manager.randomizeManagerId());
        manager.setFirstName("Mariusz");
        manager.setLastName("Konieczny");
        manager.setStreet("Powstania Listopadowego 45/23");
        manager.setZipCode("80-287");
        manager.setCity("Gdansk");
        manager.setPhoneNumber(5678987);
        manager.setBirthDate(LocalDate.of(1989,05,04));
        manager.setDepartment("Technologia");
        manager.setPosition("Informatyk");
        manager.setSalary(BigDecimal.valueOf(5400));
        manager.setHireDate(LocalDate.of(2020, 06,01));
        manager.setEmail(manager.emailGeneratorForManager());

       AdminDAOImpl dao = new AdminDAOImpl();
       // dao.addManager(manager);
       //dao.addEmployee(employee);
        dao.getManagerById("MNG932514");

        /*Team team = new Team();
        team.setTeamId(team.randomizeTeamId());
        team.setCreatedOn(LocalDate.now());
        team.setTeamDescription("Netflix");
        team.setTeamLeader("MNG987653");
        team.setTeamName("Prog");
        ManagerDAOImpl managerDAO = new ManagerDAOImpl();
        managerDAO.createTeam(team);

         */


        //TeamMapperDAOImpl teamMapperDAO = new TeamMapperDAOImpl();
        //teamMapperDAO.addTeamMember();




    }
}

