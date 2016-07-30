package com.mycompany.developerstimetracker.handler;

import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;

import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 27.04.2016.
 */
public interface DataHandler {
    List<Time> timeHandler(int id, int numOfResults);
    User getSingleUser(int id);
    List<User> getAllUsers();
    User addNewUser(User newUser);
    Time updateUserTime(Time newTime, int id);
    int getTotalTime (Month month, int year, int id);
}
