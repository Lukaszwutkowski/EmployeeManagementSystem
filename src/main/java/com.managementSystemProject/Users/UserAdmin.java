package com.managementSystemProject.Users;

import javax.persistence.*;

@Entity
@Table(name = "user_admin")
public class UserAdmin {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userId;

    @Column(name = "user_admin")
    private String userName;

    @Column(name = "password")
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
