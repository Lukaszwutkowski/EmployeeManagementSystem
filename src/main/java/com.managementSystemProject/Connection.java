package com.managementSystemProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {

  /*  private static final String URL = "jdbc:mysql://localhost:3306/sda_library?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private java.sql.Connection connection;

    private void createConnection() {
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "RootPassword95");
        try {
            connection = DriverManager.getConnection(URL, prop);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static String getURL() {
        return URL;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

   */
}
