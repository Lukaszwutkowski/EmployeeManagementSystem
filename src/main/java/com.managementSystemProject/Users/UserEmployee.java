package com.managementSystemProject.Users;

import javax.persistence.*;

@Entity
@Table(name = "emp_users")
@Access(AccessType.PROPERTY)
public class UserEmployee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Access(AccessType.FIELD)
    private int userId;

    @Column(name = "user_employee")
    private String userName;

    @Column(name = "password")
    private String password;

    private EntityManager em;

    private void createEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private String message = "error";

    private void closeEntityManager() {
        em.close();
    }


    public String addUserEmployee(UserEmployee userEmployee) {
        createEntityManager();
        em.getTransaction().begin();
        em.persist(userEmployee);
        if (userEmployee.getUserId() != 0) {
            message = "User for Employee Successfully Created.";
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }

    public UserEmployee() {}

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
