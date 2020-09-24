package com.managementSystemProject.Users;

import javax.persistence.*;

@Entity
@Table(name = "man_users")
@Access(AccessType.PROPERTY)
public class UserManager {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    @Access(AccessType.FIELD)
    private int userId;

    @Column(name = "user_manager")
    private String userName;

    @Column(name = "password")
    private String password;


    private EntityManager em;

    private void createEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private void closeEntityManager() {
        em.close();
    }

    String message = "error";

    public String addUserManager(UserManager userManager) {
        createEntityManager();
        em.getTransaction().begin();
        em.persist(userManager);
        if (userManager.getUserId() != 0) {
            message = "User for Manager successfully Created.";
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }


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
