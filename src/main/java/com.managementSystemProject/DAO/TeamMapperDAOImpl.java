package com.managementSystemProject.DAO;

import com.managementSystemProject.Model.Employee;
import com.managementSystemProject.Model.Manager;
import com.managementSystemProject.Model.Team;
import com.managementSystemProject.Model.TeamMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TeamMapperDAOImpl<EmployeeDAOImpl, TeamDAOImpl> implements TeamMapperDAO {

    private static Logger log = Logger.getLogger(String.valueOf(TeamMapperDAOImpl.class));

    ManagerDAOImpl teamDAO;

    private EntityManager em;

    private void createEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = factory.createEntityManager();
    }

    private void closeEntityManager(){
        em.close();
    }

    //AdminDAOImpl adminDAO;

    String message = "error";

    @Override
    public boolean createTeamLeader(Team team) {
        AdminDAOImpl adminDAO = new AdminDAOImpl();
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
    public Manager getLeader(String teamId) {
        return em.createQuery("SELECT tem FROM TeamMapper tem where tem.team.teamId = '" + teamId+"' and tem.isLeader = true", TeamMapper.class).getResultList().get(0).getManager();
    }

    @Override
    public List<Employee> getTeamMembers(String teamId) {
        List<Employee> employees = new ArrayList<>();

        List<TeamMapper> mapperObjs = em.createQuery("SELECT tem FROM TeamMapper tem where tem.team.teamId = '" + teamId+"' and tem.isLeader = false", TeamMapper.class).getResultList();

        for(TeamMapper obj : mapperObjs){
            employees.add(obj.getEmployee());
        }
        return employees;
    }

    @Override
    public List<Employee> listAvaibleEmployees() {
        List<Employee> availableEmployees = em.createQuery("SELECT e FROM Employee e WHERE e.employee_id NOT IN (select tem.employee.employeeId from TeamMapper tem)", Employee.class).getResultList();
        return availableEmployees;
    }

    @Override
    public boolean removeTeamMember(String employeeId) {
        boolean deleted = false;

        Query q = em.createQuery("Delete from TeamMapper tem where tem.employee.employeeId ='"+employeeId+"'");
        int deletedCount = q.executeUpdate();

        log.info("no. of rows deleted:"+deletedCount);
        deleted = true;

        return deleted;
    }

    @Override
    public boolean addTeamMember(String teamId, String employeeId) {
        boolean teamMemberAdded = false;
        AdminDAOImpl adminDAO = new AdminDAOImpl();

        TeamMapper mapperObj = new TeamMapper();
        mapperObj.setTeam(teamDAO.getTeamById(teamId));
        mapperObj.setEmployee(adminDAO.getEmployeeById(employeeId));
        mapperObj.setLeader(false);
        mapperObj.setAssigned(true);

        em.persist(mapperObj);

        if(!mapperObj.getMapperId().equals(null)){
            teamMemberAdded = true;
        }

        return teamMemberAdded;
    }
}
