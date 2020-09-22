package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

public class TestDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/management_sys?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection connection;

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

   /* public boolean addPerson() {
        // TODO poprawic ta metode tak zeby nie wymagala person_id
        createConnection();
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int birthYear = scanner.nextInt();
        int birthMonth = scanner.nextInt();
        int birthDay = scanner.nextInt();
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        String street = scanner.nextLine();
        String city = scanner.nextLine();
        String zipCode = scanner.nextLine();
        String department = scanner.nextLine();
        BigDecimal salary = scanner.nextBigDecimal();
        int hireYear = scanner.nextInt();
        int hireMonth = scanner.nextInt();
        int hireDay = scanner.nextInt();
        LocalDate hireDate = LocalDate.of(hireYear, hireMonth, hireDay);
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + "xyzcompany.com";
        Employee employee = new Employee(firstName, lastName, birthDate, street, city, zipCode, email, department, salary, hireDate);

        String add = String.format("insert into employees(employee_id, birth_date, city, department, email, first_name, hire_date, last_name, salary, street, zip_code) values('%s','%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, '%s','%s')",
                employee.getEmployeeId(), birthDate, city, department, email, firstName, hireDate, lastName, salary, street, zipCode);
       // String add = "insert into employees(employee_id, birth_date, city, department, email, first_name, hire_date, last_name, salary, street, zip_code) " +
         //       "values(" + ","+ "'" + birthDate + "'" + "," + "'" + city + "'" + "," + "'" + department + "'" + "," + "'" + email + "'" + "," + "'" + firstName + "'" + "," + "'" + hireDate + "'" + "," + "'" + lastName + "'" + ","  + salary +  "," + "'" + street + "'" + "," + "'" + zipCode + "'" + ");";
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(add);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        closeConnection();
        return result > 0;
    }

    */
}
