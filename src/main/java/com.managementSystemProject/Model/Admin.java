package com.managementSystemProject.Model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int adminId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

}
