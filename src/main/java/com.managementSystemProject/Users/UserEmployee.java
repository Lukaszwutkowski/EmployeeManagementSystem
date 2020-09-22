package com.managementSystemProject.Users;

import javax.persistence.*;

@Entity
@Table(name = "emp_users")
public class UserEmployee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "password")
    private String password;

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
