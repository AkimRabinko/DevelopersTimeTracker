package com.mycompany.developerstimetracker.handler.impl;

import com.mycompany.developerstimetracker.dao.UserDAO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.handler.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 27.04.2016.
 */
@Service
public class DataHandlerImpl implements DataHandler{

    @Autowired
    private UserDAO userDAO;

    public DataHandlerImpl() throws ClassNotFoundException {
    }

    public List<Time> timeHandler(int id, int numOfResults) {
        return userDAO.findTimeById(id, numOfResults);
    }

    public User getSingleUser(int id) {
        return userDAO.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAllUsers();
    }

    public User addNewUser(User newUser) {
        return userDAO.addNewUser(newUser);
    }

    public Time updateUserTime(Time newTime, int id) {
        return userDAO.updateUserTime(newTime , id);
    }

    public int getTotalTime(Month month, int year, int id) {
        return userDAO.getTotalTime(month, year, id);
    }
}