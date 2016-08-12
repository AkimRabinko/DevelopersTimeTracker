package com.mycompany.developerstimetracker.handler.impl;

import com.mycompany.developerstimetracker.dao.UserDAO;
import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Project;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.handler.DataHandler;
import com.mycompany.developerstimetracker.service.DataService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 27.04.2016.
 */
@Service
public class DataHandlerImpl implements DataHandler{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DataService dataService;

    public DataHandlerImpl() throws ClassNotFoundException {
    }

    public List<Time> timeHandlerByLimit(int id, int numOfResults) {
        return userDAO.findTimeByIdLimit(id, numOfResults);
    }

    public List<Time> timeHandlerByMonth(int id, Month month) {
        return userDAO.findTimeByIdMonth(id, month);
    }

    public List<Time> timeHandlerByRange(int id, Date fromDate, Date toDate){
        return userDAO.findTimeByIdRange(id, fromDate, toDate);
    }

    public User getSingleUser(int id) {
        return userDAO.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAllUsers();
    }

    public User addNewUser(UserTO newUser) {
        dataService.convertToUserEntity(newUser);
        return userDAO.addNewUser(dataService.getConvertedUser());
    }

    public Time updateUserTime(int userId, String projectName, TimeTO newTime) {
        dataService.convertToTimeEntity(newTime);
        return userDAO.updateUserTime(userId, projectName, dataService.getConvertedTime());
    }

    public int getTotalTime(Month month, int id) {
        return userDAO.getTotalTime(month, id);
    }

    public List<Project> getAvailableProjects() {
        return userDAO.getAvailableProjects();
    }

    public Project addNewProject(Project project) {
        return userDAO.addNewProject(project);
    }

    public String addUserToProject(int userId, String projectName) {
        return userDAO.addUserToProject(userId, projectName);
    }

    @Override
    public String removeUserFromProject(int userId, String projectName) {
        return userDAO.removeUserFromProject(userId, projectName);
    }

    public List<User> getUsersInProject(String projectName) {
        return userDAO.getUsersInProject(projectName);
    }

    public String getReport() throws JRException {
        return userDAO.getReport();
    }

}