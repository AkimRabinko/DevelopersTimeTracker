package com.mycompany.developerstimetracker.dao;

import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;

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
    Time updateUserTime(Time newTime, int id);
    List<Time> findTimeById(int id, int numOfResults);
    int getTotalTime(Month month, int year, int id);
<<<<<<< HEAD

=======
>>>>>>> master
}
