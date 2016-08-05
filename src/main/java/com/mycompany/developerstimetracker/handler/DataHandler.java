package com.mycompany.developerstimetracker.handler;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Project;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import net.sf.jasperreports.engine.JRException;

import java.sql.Date;
import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 27.04.2016.
 */
public interface DataHandler {
    List<Time> timeHandlerByLimit(int id, int numOfResults);
    List<Time> timeHandlerByMonth(int id, Month month);
    List<Time> timeHandlerByRange(int id, Date fromDate, Date toDate);
    User getSingleUser(int id);
    List<User> getAllUsers();
    User addNewUser(UserTO newUser);
    Time updateUserTime(int userId, String projectName, TimeTO newTime);
    int getTotalTime (Month month, int id);
    List<Project> getAvailableProjects();
    String getReport() throws JRException;
}
