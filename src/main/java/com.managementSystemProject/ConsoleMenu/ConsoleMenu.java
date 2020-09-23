package com.managementSystemProject.ConsoleMenu;

import com.managementSystemProject.DAO.AdminDAOImpl;
import com.managementSystemProject.DAO.TestDAO;
import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleMenu {

    private static final Scanner scanner = new Scanner(System.in);

    private static final AdminDAOImpl adminDAO = new AdminDAOImpl();


    public void startMenu() {
        System.out.println("Start Menu:\n" +
                "Choose your option\n" +
                "1.Log in as Admin\n" +
                "2.Log in as Manager\n" +
                "3.Log in as Employee\n" +
                "4.Quit");
    }

    public void managerMenu() {
        System.out.println("Welcome:\n" +
                "Choose your option\n" +
                "1.Choose Employee\n" +
                "2.Choose Manager\n" +
                "3.Send Message To Employee\n" +
                "4.Send Message To Manager\n" +
                "5.Show All Employees\n");
    }

    public void employeeMenu() {
        System.out.println("Welcome:\n" +
                "Choose your option\n" +
                "1.Choose Employee\n" +
                "2.Choose Manager\n" +
                "3.Send Employee\n" +
                "4.Send Message To Manager\n" +
                "5.Show All Employees\n");
    }

    public void adminMenu() {
        System.out.println(
                "Choose your option\n" +
                        "1.Manage Employee\n" +
                        "2.Manage Manager\n" +
                        "3.Manage Team\n" +
                        "4.Exit\n");
    }

    public void findEmployeeMenu() {
        System.out.println(
                "Choose your option\n" +
                        "1.Find Employee By Id\n" +
                        "2.Find Employee By First name\n" +
                        "3.Find Employee By Last name\n" +
                        "4.Find Employee By Department" +
                        "5.Get List of All Employees" +
                        "6.Return\n");
        while (true) {
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose your option by type in number");
                continue;
            }
            switch (number) {
                case 1:
                    System.out.println("Enter the employee ID");
                    String employeeIdToFind = scanner.nextLine();
                    adminDAO.getEmployeeById(employeeIdToFind);
                case 2:
                    System.out.println("Enter the first name of employee you want to find");
                    adminDAO.findEmployeeByFirstName();
                case 3:
                    System.out.println("Enter the last name of employee you want to find");
                    adminDAO.findEmployeeByLastName();
                case 4:
                    System.out.println("Enter the department name to get list of all employees who work there");
                    adminDAO.getEmployeesByDepartment();
                case 5:
                    adminDAO.getAllEmployees();
                case 6:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }
        }
    }

    public void findManagerMenu() {
        System.out.println(
                "Choose your option\n" +
                        "1.Find Manager By Id\n" +
                        "2.Find Manager By First name\n" +
                        "3.Find Manager By Last name\n" +
                        "4.Find Manager By Department" +
                        "5.Get List of All Managers" +
                        "6.Return\n");
        while (true) {
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose your option by type in number");
                continue;
            }
            switch (number) {
                case 1:
                    System.out.println("Enter the manager ID");
                    String managerIdToFind = scanner.nextLine();
                    adminDAO.getManagerById(managerIdToFind);
                case 2:
                    System.out.println("Enter the first name of manager you want to find");
                    String firstNameTmp = scanner.nextLine();
                    adminDAO.getManagerByFirstName(firstNameTmp);
                case 3:
                    System.out.println("Enter the last name of manager you want to find");
                    String lastNameTmp = scanner.nextLine();
                    adminDAO.getManagerByLastName(lastNameTmp);
                case 4:
                    System.out.println("Enter the department name to get list of all managers who work there");
                    adminDAO.getManagersByDepartment();
                case 5:
                    adminDAO.getAllManagers();
                case 6:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }
        }
    }

    public void manageEmployeeByAdminMenu() {

        System.out.println("Choose your option\n" +
                "1.Create new Employee\n" +
                "2.Modify Employee\n" +
                "3.Delete Employee\n" +
                "4.Find Employee" +
                "5.Return");
        while (true) {
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose your option by type in number");
                continue;
            }
            switch (number) {
                case 1:
                    Employee employee = new Employee();
                    employee.setEmployeeId(employee.randomizeEmployeeId());
                    System.out.println("Put first name");
                    employee.setFirstName(scanner.nextLine());
                    System.out.println("Put second name");
                    employee.setLastName(scanner.nextLine());
                    System.out.println("Put street address");
                    employee.setStreet(scanner.nextLine());
                    System.out.println("Put zipCode");
                    employee.setZipCode(scanner.nextLine());
                    System.out.println("Put city");
                    employee.setCity(scanner.nextLine());
                    System.out.println("Put telephone number");
                    employee.setPhoneNumber(scanner.nextInt());
                    System.out.println("Put year of the birth date");
                    int birthYear = scanner.nextInt();
                    System.out.println("Put month of the birth date");
                    int birthMonth = scanner.nextInt();
                    System.out.println("Put day of the birth date");
                    int birthDay = scanner.nextInt();
                    employee.setBirthDate(LocalDate.of(birthYear, birthMonth, birthDay));
                    System.out.println("Put the name of Department");
                    employee.setDepartment(scanner.nextLine());
                    System.out.println("Put the job position");
                    employee.setPosition(scanner.nextLine());
                    System.out.println("Put the month salary");
                    double salaryTmp = scanner.nextInt();
                    employee.setSalary(BigDecimal.valueOf(salaryTmp));
                    System.out.println("Put year of the hire date");
                    int hireDateYear = scanner.nextInt();
                    System.out.println("Put month of the hire date");
                    int hireDateMonth = scanner.nextInt();
                    System.out.println("Put day of the hire date");
                    int hireDateDay = scanner.nextInt();
                    employee.setHireDate(LocalDate.of(hireDateYear, hireDateMonth, hireDateDay));
                    employee.setEmail(employee.emailGeneratorForEmployee());
                    adminDAO.addEmployee(employee);
                    break;
                case 2:
                    Employee employeeModify = new Employee();
                    System.out.println("Enter the employee ID you want to change");
                    String employeeIdTmp = scanner.nextLine();
                    employeeModify.setEmployeeId(employeeIdTmp);
                    System.out.println("Put first name");
                    employeeModify.setFirstName(scanner.nextLine());
                    System.out.println("Put second name");
                    employeeModify.setLastName(scanner.nextLine());
                    System.out.println("Put street address");
                    employeeModify.setStreet(scanner.nextLine());
                    System.out.println("Put zipCode");
                    employeeModify.setZipCode(scanner.nextLine());
                    System.out.println("Put city");
                    employeeModify.setCity(scanner.nextLine());
                    System.out.println("Put telephone number");
                    employeeModify.setPhoneNumber(scanner.nextInt());
                    System.out.println("Put year of the birth date");
                    int birthYearModify = scanner.nextInt();
                    System.out.println("Put month of the birth date");
                    int birthMonthModify = scanner.nextInt();
                    System.out.println("Put day of the birth date");
                    int birthDayModify = scanner.nextInt();
                    employeeModify.setBirthDate(LocalDate.of(birthYearModify, birthMonthModify, birthDayModify));
                    System.out.println("Put the name of Department");
                    employeeModify.setDepartment(scanner.nextLine());
                    System.out.println("Put the job position");
                    employeeModify.setPosition(scanner.nextLine());
                    System.out.println("Put the month salary");
                    double salaryTmpModify = scanner.nextInt();
                    employeeModify.setSalary(BigDecimal.valueOf(salaryTmpModify));
                    System.out.println("Put year of the hire date");
                    int hireDateYearModify = scanner.nextInt();
                    System.out.println("Put month of the hire date");
                    int hireDateMonthModify = scanner.nextInt();
                    System.out.println("Put day of the hire date");
                    int hireDateDayModify = scanner.nextInt();
                    employeeModify.setHireDate(LocalDate.of(hireDateYearModify, hireDateMonthModify, hireDateDayModify));
                    employeeModify.setEmail(employeeModify.emailGeneratorForEmployee());
                    adminDAO.modifyEmployee(employeeIdTmp, employeeModify);
                    break;
                case 3:
                    System.out.println("Enter the employee ID you want to delete");
                    String employeeIdToDelete = scanner.nextLine();
                    System.out.println("You are going to delete that Employee are you sure ? Press: Y - for yes or N - for no");
                    String c = scanner.next();
                    if (c.equals("Y")) {
                        adminDAO.deleteEmployee(employeeIdToDelete);
                    } else break;
                    break;
                case 4:
                    findEmployeeMenu();
                case 5:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }

        }
    }

    public void manageManagerByAdminMenu() {

        System.out.println("Choose your option\n" +
                "1.Create new Manager\n" +
                "2.Modify Manager\n" +
                "3.Delete Manager\n" +
                "4.Find Manager" +
                "5.Return");
        while (true) {
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose your option by type in number");
                continue;
            }
            switch (number) {
                case 1:
                    Manager manager = new Manager();
                    manager.setManagerId(manager.randomizeManagerId());
                    System.out.println("Put first name");
                    manager.setFirstName(scanner.nextLine());
                    System.out.println("Put second name");
                    manager.setLastName(scanner.nextLine());
                    System.out.println("Put street address");
                    manager.setStreet(scanner.nextLine());
                    System.out.println("Put zipCode");
                    manager.setZipCode(scanner.nextLine());
                    System.out.println("Put city");
                    manager.setCity(scanner.nextLine());
                    System.out.println("Put telephone number");
                    manager.setPhoneNumber(scanner.nextInt());
                    System.out.println("Put year of the birth date");
                    int birthYear = scanner.nextInt();
                    System.out.println("Put month of the birth date");
                    int birthMonth = scanner.nextInt();
                    System.out.println("Put day of the birth date");
                    int birthDay = scanner.nextInt();
                    manager.setBirthDate(LocalDate.of(birthYear, birthMonth, birthDay));
                    System.out.println("Put the name of Department");
                    manager.setDepartment(scanner.nextLine());
                    System.out.println("Put the job position");
                    manager.setPosition(scanner.nextLine());
                    System.out.println("Put the month salary");
                    double salaryTmp = scanner.nextInt();
                    manager.setSalary(BigDecimal.valueOf(salaryTmp));
                    System.out.println("Put year of the hire date");
                    int hireDateYear = scanner.nextInt();
                    System.out.println("Put month of the hire date");
                    int hireDateMonth = scanner.nextInt();
                    System.out.println("Put day of the hire date");
                    int hireDateDay = scanner.nextInt();
                    manager.setHireDate(LocalDate.of(hireDateYear, hireDateMonth, hireDateDay));
                    manager.setEmail(manager.emailGeneratorForManager());
                    adminDAO.addManager(manager);
                    break;
                case 2:
                    Manager managerModify = new Manager();
                    System.out.println("Enter the employee ID you want to change");
                    String managerIdTmp = scanner.nextLine();
                    managerModify.setManagerId(managerIdTmp);
                    System.out.println("Put first name");
                    managerModify.setFirstName(scanner.nextLine());
                    System.out.println("Put second name");
                    managerModify.setLastName(scanner.nextLine());
                    System.out.println("Put street address");
                    managerModify.setStreet(scanner.nextLine());
                    System.out.println("Put zipCode");
                    managerModify.setZipCode(scanner.nextLine());
                    System.out.println("Put city");
                    managerModify.setCity(scanner.nextLine());
                    System.out.println("Put telephone number");
                    managerModify.setPhoneNumber(scanner.nextInt());
                    System.out.println("Put year of the birth date");
                    int birthYearModify = scanner.nextInt();
                    System.out.println("Put month of the birth date");
                    int birthMonthModify = scanner.nextInt();
                    System.out.println("Put day of the birth date");
                    int birthDayModify = scanner.nextInt();
                    managerModify.setBirthDate(LocalDate.of(birthYearModify, birthMonthModify, birthDayModify));
                    System.out.println("Put the name of Department");
                    managerModify.setDepartment(scanner.nextLine());
                    System.out.println("Put the job position");
                    managerModify.setPosition(scanner.nextLine());
                    System.out.println("Put the month salary");
                    double salaryTmpModify = scanner.nextInt();
                    managerModify.setSalary(BigDecimal.valueOf(salaryTmpModify));
                    System.out.println("Put year of the hire date");
                    int hireDateYearModify = scanner.nextInt();
                    System.out.println("Put month of the hire date");
                    int hireDateMonthModify = scanner.nextInt();
                    System.out.println("Put day of the hire date");
                    int hireDateDayModify = scanner.nextInt();
                    managerModify.setHireDate(LocalDate.of(hireDateYearModify, hireDateMonthModify, hireDateDayModify));
                    managerModify.setEmail(managerModify.emailGeneratorForManager());
                    adminDAO.modifyManager(managerIdTmp, managerModify);
                    break;
                case 3:
                    System.out.println("Enter the manager ID you want to delete");
                    String managerIdToDelete = scanner.nextLine();
                    System.out.println("You are going to delete that Manager are you sure ? Press: Y - for yes or N - for no");
                    String c = scanner.next();
                    if (c.equals("Y")) {
                        adminDAO.deleteManager(managerIdToDelete);
                    } else break;
                    break;
                case 4:
                    findManagerMenu();
                case 5:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }

        }
    }

    public void manageTeamByAdminMenu() {
        System.out.println(
                "Choose your option\n" +
                        "1.Get list of all teams\n" +
                        "2.Return\n");
        while (true) {
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose your option by type in number");
                continue;
            }
            switch (number) {
                case 1:
                    adminDAO.getTeams();
                case 2:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }
        }
    }

    public void correctPasswordAdmin() {

        System.out.println("Welcome in Management System");
        while (true) {
            ConsoleMenu consoleMenu = new ConsoleMenu();
            consoleMenu.adminMenu();
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose your option by type in number");
                continue;
            }
            switch (number) {
                case 1:
                    consoleMenu.manageEmployeeByAdminMenu();
                    break;
                case 2:
                    consoleMenu.manageManagerByAdminMenu();
                    break;
                case 3:
                    consoleMenu.manageTeamByAdminMenu();
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }

        }
    }
}
