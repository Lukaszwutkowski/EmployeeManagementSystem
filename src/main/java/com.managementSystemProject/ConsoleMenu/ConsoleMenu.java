package com.managementSystemProject.ConsoleMenu;

import com.managementSystemProject.DAO.AdminDAOImpl;
import com.managementSystemProject.Generator.PasswordGenerator;
import com.managementSystemProject.Login.LoginAdmin;
import com.managementSystemProject.Login.LoginEmployee;
import com.managementSystemProject.Login.LoginManager;
import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Users.UserEmployee;

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
                    LoginAdmin loginAdmin = new LoginAdmin();
                    loginAdmin.loginActionPerformed();
                case 2:
                    LoginManager loginManager = new LoginManager();
                    loginManager.loginActionPerformed();
                case 3:
                    LoginEmployee loginEmployee = new LoginEmployee();
                    loginEmployee.loginActionPerformed();
                case 4:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Fault value");
            }
        }
    } // TODO OK

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
    } // TODO OK

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
                    System.out.println("Choose the number for Department:\n " +
                            "1.PRODUCTION || 2.R&D || 3.SALE || 4.MARKETING || 5.HR || 6.FINANCE");
                    int dep = scanner.nextInt();
                    if (dep == 1) {
                        employee.setDepartment("Production");
                    } else if (dep == 2) {
                        employee.setDepartment("R&D");
                    } else if (dep == 3) {
                        employee.setDepartment("Sale");
                    } else if (dep == 4) {
                        employee.setDepartment("Marketing");
                    } else if (dep == 5) {
                        employee.setDepartment("HR");
                    } else if (dep == 6) {
                        employee.setDepartment("Finance");
                    }
                    System.out.println("Choose the number for Position:\n");
                    if (dep == 1) {
                        System.out.println("1.PROCESSING WORKER || 2.WAREHOUSE WORKER || 3.PRODUCTION WORKER || 4.OPERATOR || 5.PRODUCTION CONTROLLER || 6.PRODUCTION ENGINEER");
                        int prod = scanner.nextInt();
                        if (prod == 1) {
                            employee.setPosition("Processing worker");
                        } else if (prod == 2) {
                            employee.setPosition("Warehouse worker");
                        } else if (prod == 3) {
                            employee.setPosition("Production worker");
                        } else if (prod == 4) {
                            employee.setPosition("Operator");
                        } else if (prod == 5) {
                            employee.setPosition("Production controller");
                        } else if (prod == 6) {
                            employee.setPosition("Production engineer");
                        }
                    } else if (dep == 2) {
                        System.out.println("1.LAB TECHNICIAN || 2.MATERIAL SCIENCE EXPERT || 3.R&D CONTROLLER || 6.R&D ENGINEER");
                        int rd = scanner.nextInt();
                        if (rd == 1) {
                            employee.setPosition("Lab technician");
                        } else if (rd == 2) {
                            employee.setPosition("Material Science expert");
                        } else if (rd == 3) {
                            employee.setPosition("R&D controller");
                        } else if (rd == 4) {
                            employee.setPosition("R&D engineer");
                        }
                    } else if (dep == 3) {
                        System.out.println("1.SALES ASSISTANT || 2.RETAIL SALES || 3.SALES ENGINEER");
                        int sales = scanner.nextInt();
                        if (sales == 1) {
                            employee.setPosition("Sales assistant");
                        } else if (sales == 2) {
                            employee.setPosition("Retail sales");
                        } else if (sales == 3) {
                            employee.setPosition("Sales engineer");
                        }
                    } else if (dep == 4) {
                        System.out.println("1.WEB MARKETING SPECIALIST || 2.MARKETING DATA ANALYST || 3.JUNIOR PRODUCT MARKETING ASSOCIATE || 4.PRODUCT MARKETING ASSOCIATE");
                        int mar = scanner.nextInt();
                        if (mar == 1){
                            employee.setPosition("Web marketing specialist");
                        } else if (mar == 2){
                            employee.setPosition("Marketing data analyst");
                        } else if (mar == 3){
                            employee.setPosition("Junior product marketing associate");
                        } else if (mar == 4){
                            employee.setPosition("Product marketing associate");
                        }
                    } else if (dep == 5) {
                        System.out.println("1.HR CONSULTANT || 2.HR ADMINISTRATOR || 3.RECRUITER");
                        int hr = scanner.nextInt();
                        if (hr == 1){
                            employee.setPosition("HR consultant");
                        } else if (hr == 2){
                            employee.setPosition("HR administrator");
                        } else if (hr == 3){
                            employee.setPosition("Recruiter");
                        }
                    } else if (dep == 6) {
                        System.out.println("1.FINANCE ASSISTANT || 2.JUNIOR FINANCIAL ANALYST || 3.FINANCIAL ANALYST || 4.BUDGET ANALYST || 5.JUNIOR ACCOUNTANT || 6.ACCOUNTANT");
                        int fin = scanner.nextInt();
                        if (fin == 1){
                            employee.setPosition("Finance assistant");
                        } else if (fin == 2){
                            employee.setPosition("Junior financial analyst");
                        } else if (fin == 3){
                            employee.setPosition("Financial analyst");
                        } else if (fin == 4){
                            employee.setPosition("Budget analyst");
                        } else if (fin == 5){
                            employee.setPosition("Junior accountant");
                        } else if (fin == 6){
                            employee.setPosition("Accountant");
                        }
                    }
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
                    PasswordGenerator passwordGenerator = new PasswordGenerator();
                    UserEmployee userEmployee = new UserEmployee();
                    userEmployee.setUserName(employee.emailGeneratorForEmployee());
                    userEmployee.setPassword(passwordGenerator.getPassword());
                    userEmployee.addUserEmployee(userEmployee);
                    manageEmployeeByAdminMenu();
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
                    String depMod = scanner.nextLine();
                    employeeModify.setDepartment(depMod);
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
                    manageEmployeeByAdminMenu();
                    break;
                case 3:
                    System.out.println("Enter the employee ID you want to delete");
                    String employeeIdToDelete = scanner.nextLine();
                    System.out.println("You are going to delete that Employee are you sure ? Press: Y - for yes or N - for no");
                    String c = scanner.next();
                    if (c.equals("Y")) {
                        adminDAO.deleteEmployee(employeeIdToDelete);
                        manageEmployeeByAdminMenu();
                    } else break;
                    break;
                case 4:
                    findEmployeeMenu();
                case 5:
                    adminMenu();
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
                    System.out.println("Choose the number for Department:\n " +
                            "1.PRODUCTION || 2.R&D || 3.SALE || 4.MARKETING || 5.HR || 6.FINANCE");
                    int dep = scanner.nextInt();
                    if (dep == 1) {
                        manager.setDepartment("Production");
                    } else if (dep == 2) {
                        manager.setDepartment("R&D");
                    } else if (dep == 3) {
                        manager.setDepartment("Sale");
                    } else if (dep == 4) {
                        manager.setDepartment("Marketing");
                    } else if (dep == 5) {
                        manager.setDepartment("HR");
                    } else if (dep == 6) {
                        manager.setDepartment("Finance");
                    }
                    System.out.println("Choose the number for Position:\n");
                    if (dep == 1) {
                        System.out.println("1.DIVISION MANAGER || 2.WAREHOUSE MANAGER || 3.PRODUCTION MANAGER || 4.PROCESS OPERATOR MANAGER || 5.SENIOR CONTROLLER || 6.SENIOR ENGINEER");
                        int prod = scanner.nextInt();
                        if (prod == 1) {
                            manager.setPosition("Division manager");
                        } else if (prod == 2) {
                            manager.setPosition("Warehouse manager");
                        } else if (prod == 3) {
                            manager.setPosition("Production manager");
                        } else if (prod == 4) {
                            manager.setPosition("Process operator manager");
                        } else if (prod == 5) {
                            manager.setPosition("Senior controller");
                        } else if (prod == 6) {
                            manager.setPosition("Senior engineer");
                        }
                    } else if (dep == 2) {
                        System.out.println("1.RESEARCH MANAGER || 2.R&D DIRECTOR || 3.PROJECT MANAGER");
                        int rd = scanner.nextInt();
                        if (rd == 1) {
                            manager.setPosition("Research manager");
                        } else if (rd == 2) {
                            manager.setPosition("R&D director");
                        } else if (rd == 3) {
                            manager.setPosition("Project manager");
                        }
                    } else if (dep == 3) {
                        System.out.println("1.SALES MANAGER || 2.REGIONAL SALES MANAGER || 3.NATIONAL SALES DIRECTOR");
                        int sales = scanner.nextInt();
                        if (sales == 1) {
                            manager.setPosition("Sales manager");
                        } else if (sales == 2) {
                            manager.setPosition("Regional sales manager");
                        } else if (sales == 3) {
                            manager.setPosition("National sales director");
                        }
                    } else if (dep == 4) {
                        System.out.println("1.DIGITAL PRODUCT MARKETING MANAGER || 2.BRAND MANAGER || 3.CONTENT MARKETING MANAGER || 4.PRODUCT MARKETING MANAGER");
                        int mar = scanner.nextInt();
                        if (mar == 1){
                            manager.setPosition("Digital product marketing manager");
                        } else if (mar == 2){
                            manager.setPosition("Brand manager");
                        } else if (mar == 3){
                            manager.setPosition("Content marketing manager");
                        } else if (mar == 4){
                            manager.setPosition("Product marketing manager");
                        }
                    } else if (dep == 5) {
                        System.out.println("1.HR MANAGER || 2.SENIOR HR ADMINISTRATOR || 3.SENIOR HR SPECIALIST");
                        int hr = scanner.nextInt();
                        if (hr == 1){
                            manager.setPosition("HR manager");
                        } else if (hr == 2){
                            manager.setPosition("Senior HR administrator");
                        } else if (hr == 3){
                            manager.setPosition("Senior HR specialist");
                        }
                    } else if (dep == 6) {
                        System.out.println("1.FINANCE CONTROLLER || 2.RISK MANAGER || 3.FINANCE DIRECTOR || 4.CHEF FINANCIAL OFFICER || 5.FINANCE MANAGER || 6.ACCOUNTING MANAGER");
                        int fin = scanner.nextInt();
                        if (fin == 1){
                            manager.setPosition("Finance controller");
                        } else if (fin == 2){
                            manager.setPosition("Risk manager");
                        } else if (fin == 3){
                            manager.setPosition("Finance director");
                        } else if (fin == 4){
                            manager.setPosition("Chef financial officer");
                        } else if (fin == 5){
                            manager.setPosition("Finance manager");
                        } else if (fin == 6){
                            manager.setPosition("Accounting manager");
                        }
                    }
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
