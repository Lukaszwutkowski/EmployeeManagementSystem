package com.managementSystemProject.Login;

import com.managementSystemProject.ConsoleMenu.ConsoleMenu;
import com.managementSystemProject.DAO.AdminDAOImpl;
import com.managementSystemProject.DAO.TestDAO;

import java.sql.*;
import java.util.Scanner;


public class LoginAdmin implements Login {

    private String userName;
    private String password;

    private static final Scanner scanner = new Scanner(System.in);

    private static final String URL = "jdbc:mysql://localhost:3306/emp_man_sys?useLegacyDatetimeCode=false&serverTimezone=UTC";

    @Override
    public void loginActionPerformed() {

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "RootPassword95");
            String query = "select * from users where username =? and password =?";

            PreparedStatement pst = connection.prepareStatement(query);
            System.out.println("Type in your email address");
            userName = scanner.next();
            System.out.println("Type in password");
            password = scanner.next();
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("username and password is correct");
                correctPasswordAdmin();
            } else {
                System.out.println("username and password is NOT correct");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    private void correctPasswordAdmin() {

        Scanner scanner = new Scanner(System.in);
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
                   // AdminDAOImpl adminDAO = new AdminDAOImpl();
                   // adminDAO.addEmployee();
                    TestDAO testDAO = new TestDAO();
                    //Employee employee = new Employee("adam", "moc",LocalDate.of(1986,04,23),"komunijna 2", "Gdansk", "45-678", "md@dfr.com", "info", BigDecimal.valueOf(4567), LocalDate.of(2020, 03, 23));
                    testDAO.addPerson();
                    break;
                case 2:
                    AdminDAOImpl adminDAO1 = new AdminDAOImpl();
                    adminDAO1.findEmployeeByFirstName();
                    break;
                case 3:
                    System.out.println("Sortuje liste dzieci");
                    break;
                case 4:
                    System.out.println("Usuwam duplikat");
                    break;
                case 5:
                    System.out.println("Imiona duza litera");
                    break;
                case 6:
                    System.out.println("Imiona mala litera");
                    break;
                case 7:
                case 8:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Wprowadzono niepoprawna wartosc");
            }

        }
    }

}


