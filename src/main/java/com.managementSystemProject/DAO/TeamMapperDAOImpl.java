package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;
import com.managementSystemProject.Model.TeamMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

public class TeamMapperDAOImpl implements TeamMapperDAO {

    private static Logger log = Logger.getLogger(String.valueOf(TeamMapperDAOImpl.class));

    private EntityManager em;

    private void createEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private void closeEntityManager(){
        em.close();
    }

    AdminDAOImpl adminDAO;

    String message = "error";

    @Override
    public boolean createTeamLeader(Team team) {
        createEntityManager();
        em.getTransaction().begin();
        boolean teamLeaderAssigned = false;

        TeamMapper mapperObj = new TeamMapper();
        mapperObj.setTeam(team);
        mapperObj.setManager(adminDAO.getManagerById(team.getTeamLeader()));
        mapperObj.setLeader(true);
        mapperObj.setAssigned(true);

        em.persist(mapperObj);

        if(!mapperObj.getMapperId().equals(null)){
            teamLeaderAssigned = true;
        }
        em.getTransaction().commit();
        closeEntityManager();

        return teamLeaderAssigned;
    }

    @Override
    public Manager getLeader(int teamId) {
        return null;
    }

    @Override
    public List<Employee> getTeamMembers(String teamId) {
        return null;
    }

    @Override
    public List<Employee> listAvaibleEmployees() {
        return null;
    }

    @Override
    public boolean removeTeamMember(String employeeId) {
        return false;
    }

    @Override
    public boolean addTeamMember(int teamId, String employeeId) {
        return false;
    }
}
