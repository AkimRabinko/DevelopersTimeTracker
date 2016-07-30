package com.mycompany.developerstimetracker.service.impl;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.service.DataService;
import org.springframework.stereotype.Service;

/**
 * Created by AkimPC on 09.07.2016.
 */

@Service
public class DataServiceImpl implements DataService {

    private User user;
    private Time time;

    @Override
    public void convertToUserEntity(UserTO userTO) {
        User user = new User();
        user.setUserName(userTO.getUserName());
        user.setUserLastName(userTO.getUserLastName());
        user.setUserLogin(userTO.getUserLogin());
        user.setUserPassword(userTO.getUserPassword());
        user.setUserPosition(userTO.getUserPosition());
        user.setUserTime(userTO.getUserTimeTO());
        user.setUserRole(userTO.getUserRole());
        this.user = user;
    }

    @Override
    public void convertToTimeEntity(TimeTO timeTO) {
        Time time = new Time();
        time.setTime(timeTO.getTime());
        time.setDescription(timeTO.getDescription());
        time.setDate(timeTO.getDate());
        time.setUser(timeTO.getUser());
        this.time = time;
    }

    @Override
    public User getConvertedUser() {
        return user;
    }

    @Override
    public Time getConvertedTime() {
        return time;
    }

}
