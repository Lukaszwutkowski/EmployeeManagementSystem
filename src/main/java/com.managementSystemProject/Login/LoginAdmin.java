package com.managementSystemProject.Login;

import com.managementSystemProject.ConsoleMenu.ConsoleMenu;
import com.managementSystemProject.SingletonCache;

import java.sql.*;
import java.util.Scanner;


public class LoginAdmin implements Login {

    private String userName;
    private String password;

    private static final String URL = "jdbc:mysql://localhost:3306/emp_man_sys?useLegacyDatetimeCode=false&serverTimezone=UTC";

    @Override
    public void loginActionPerformed() {

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "RootPassword95");
            String query = "select * from users where username =? and password =?";

            PreparedStatement pst = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
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
        System.out.println("Witaj w programie");
        SingletonCache.getInstance().getLog();
        while (true) {
            ConsoleMenu consoleMenu = new ConsoleMenu();
            consoleMenu.adminMenu();
            int number;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dokonaj wyboru wprowadzajac cyfre");
                continue;
            }
            switch (number) {
                case 1:
                    System.out.println("Podaj dziecko");
                    String name = scanner.nextLine();
                    System.out.println("Dodaje dziecko " + name);
                    SingletonCache.getInstance().log("Dodano dziecko: ");
                    break;
                case 2:

                    SingletonCache.getInstance().log("Wyswietlono liste: ");
                    break;
                case 3:
                    System.out.println("Sortuje liste dzieci");

                    SingletonCache.getInstance().log("Posortowano liste: ");
                    break;
                case 4:
                    System.out.println("Usuwam duplikat");

                    SingletonCache.getInstance().log("Usunieto duplikaty: ");
                    break;
                case 5:
                    System.out.println("Imiona duza litera");

                    SingletonCache.getInstance().log("Dokonano zmiany na duze litery: ");
                    break;
                case 6:
                    System.out.println("Imiona mala litera");

                    SingletonCache.getInstance().log("Dokonano zmiany na male litery: ");
                    break;
                case 7:
                    System.out.println(SingletonCache.getInstance().getLog());
                case 8:
                    System.out.println("Exit");
                    System.exit(-1);
                default:
                    System.out.println("Wprowadzono niepoprawna wartosc");
            }

        }
    }

  /*  EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
    EntityManager em = factory.createEntityManager();

    TypedQuery<com.employeeManagementSystem.ConsoleMenu.ConsoleMenu.Users.User> query = em.createQuery("from users u where lower(u.username) = :username and u.password = :password", com.employeeManagementSystem.ConsoleMenu.ConsoleMenu.Users.User.class);
        query.setParameter("name", textField1);
        query.setParameter("password", passwordField1);
        try {
        com.employeeManagementSystem.ConsoleMenu.ConsoleMenu.Users.User user = query.getSingleResult();
        System.out.println("com.employeeManagementSystem.ConsoleMenu.ConsoleMenu.Users.User found. com.employeeManagementSystem.ConsoleMenu.ConsoleMenu.Login.com.employeeManagementSystem.ConsoleMenu.ConsoleMenu.Login successful");
    } catch (javax.persistence.NoResultException e){
        System.out.println("No user found");
    }

   */

}


