package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
import java.util.logging.Logger;

public class ManagerDAOImpl implements ManagerDAO{

    private static Logger log = Logger.getLogger(String.valueOf(ManagerDAOImpl.class));

    private TeamMapperDAO teamMapperDAO;

    String message = "error";

    Scanner scanner = new Scanner(System.in);


    private EntityManager em;

    private void createEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private void closeEntityManager() {
        em.close();
    }

    @Override
    public String createTeam(Team team) {
        createEntityManager();
        em.getTransaction().begin();
        em.persist(team);
        teamMapperDAO = new TeamMapperDAOImpl();
        boolean leadCreated = teamMapperDAO.createTeamLeader(team);

        if(leadCreated == true){
            message = "Team Successfully Created.";
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }

    @Override
    public Team getTeamById(String teamId) {
        createEntityManager();
        em.getTransaction().begin();
        Team team = em.find(Team.class, teamId);

        Manager manager = teamMapperDAO.getLeader((team.getTeamId()));
        team.setTeamLeader(manager.getFirstName()+" "+manager.getLastName()+" ["+manager.getManagerId()+"]");
        em.getTransaction().commit();
        closeEntityManager();
        return team;
    }

    @Override
    public void updateTeam(String teamId, Team team) {
        createEntityManager();
        em.getTransaction().begin();
        Team t = em.find(Team.class, teamId);
        em.merge(t);
        message = "Team record updated successfully.";
        em.getTransaction().commit();
        closeEntityManager();
    }

    @Override
    public String deleteTeam(String teamId) {
        createEntityManager();
        em.getTransaction().begin();
        try{
            Team t = em.find(Team.class, teamId);
            em.remove(t);
            message = "Team record removed successfully.";
        }catch(Exception e){
            log.info(""+e.getStackTrace());
        }
        em.getTransaction().commit();
        closeEntityManager();
        return message;
    }

    @Override
    public boolean removeTeamMember(String employeeId) {
        return teamMapperDAO.removeTeamMember(employeeId);
    }


    @Override
    public boolean addTeamMember(String teamId, String employeeId) {
        return teamMapperDAO.addTeamMember(teamId, employeeId);
    }
}
