package com.managementSystemProject.Users;

import com.managementSystemProject.Generator.PasswordGenerator;
import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;

import javax.persistence.*;

@Entity
@Table(name = "man_users")
public class UserManager {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "password")
    private String password;

    public UserManager(String name, String password) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        Employee employee = null;
        this.name = employee.getEmail();
        this.password = passwordGenerator.getPassword();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
