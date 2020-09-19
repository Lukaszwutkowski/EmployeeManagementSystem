package com.managementSystemProject.Generator;

import com.managementSystemProject.Connection;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeIDGenerator implements IdentifierGenerator {

    private final String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Serializable result = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String prefix = "emp";
        try {
            connection = (Connection) sharedSessionContractImplementor.connection();
            statement = connection.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT next_val FROM " + DEFAULT_SEQUENCE_NAME);
        } catch (SQLException throwables) {
            System.out.println("In catch, cause : Table is not avaible.");
            try {
                statement.execute("CREATE table " + DEFAULT_SEQUENCE_NAME + "VALUES(0)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            try {
                resultSet = statement.executeQuery("SELECT next_val FROM " + DEFAULT_SEQUENCE_NAME);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        try {
            if (resultSet.next()) {
                int nextValue = 0;
                try {
                    nextValue = resultSet.getInt(1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String suffix = String.format("%04d", nextValue);
                result = prefix.concat(suffix);
                System.out.println("Custom generated sequence is: " + result);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return result;
    }
    }

