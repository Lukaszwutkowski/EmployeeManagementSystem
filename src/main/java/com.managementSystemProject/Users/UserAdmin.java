package com.managementSystemProject.Users;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class UserAdmin {

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

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
