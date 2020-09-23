package com.managementSystemProject.Login;

import com.managementSystemProject.ConsoleMenu.ConsoleMenu;
import com.managementSystemProject.DAO.AdminDAOImpl;
import com.managementSystemProject.DAO.TestDAO;

import java.sql.*;
import java.util.Scanner;


public class LoginAdmin implements Login {

    private static final ConsoleMenu c = new ConsoleMenu();

    private String userName;
    private String password;

    private static final Scanner scanner = new Scanner(System.in);

    private static final String URL = "jdbc:mysql://localhost:3306/management_sys?useLegacyDatetimeCode=false&serverTimezone=UTC";

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
                c.correctPasswordAdmin();
            } else {
                System.out.println("username and password is NOT correct");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}


