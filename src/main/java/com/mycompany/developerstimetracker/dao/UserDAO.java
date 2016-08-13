package com.mycompany.developerstimetracker.dao;

import com.mycompany.developerstimetracker.entity.Project;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import net.sf.jasperreports.engine.JRException;

import java.sql.Date;
import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 04.06.2016.
 */
public interface UserDAO {
    List<User> findAllUsers() ;
    User  findUserById(int id);
    User findUserByLogin(String login);
    User addNewUser(User newUser);
    Time updateUserTime(int userId, String projectName, Time newTime);
    List<Time> findTimeByIdLimit(int id, int numOfResults);
    List<Time> findTimeByIdMonth(int id, Month month);
    List<Time> findTimeByIdRange(int id, Date fromDate, Date toDate);
    int getTotalTime(Month month, int id);
    List<Project> getAvailableProjects(int id);
    List<Project> getAllProjects();
    Project addNewProject(Project project);
    String addUserToProject(int userId, String projectName);
    String removeUserFromProject(int userId, String projectName);
    List<User> getUsersInProject(String projectName);
    String getReportByMonth(int id, Month month, String format) throws JRException;
    String getReportByCustomRange(int id, Date fromDate, Date toDate, String format) throws JRException;


}
