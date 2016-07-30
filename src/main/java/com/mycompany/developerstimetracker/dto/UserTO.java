package com.mycompany.developerstimetracker.dto;

import com.mycompany.developerstimetracker.entity.Time;

import java.util.List;

/**
 * Created by AkimPC on 09.07.2016.
 */
public class UserTO {

    private String userName;
    private String userLastName;
    private String userPosition;
    private String userLogin;
    private String userPassword;
    private List<Time> userTime;
    private String userRole;

    public UserTO() {

    }

    public UserTO(String userLogin, String userPassword, String userName, String userLastName, String userPosition, String userRole) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userPosition = userPosition;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public List<Time> getUserTimeTO() {
        return userTime;
    }

    public void setUserTimeTO(List<Time> userTime) {
        this.userTime = userTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
