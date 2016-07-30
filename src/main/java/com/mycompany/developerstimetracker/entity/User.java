package com.mycompany.developerstimetracker.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AkimPC on 15.04.2016.
 */

@Entity
@Table(name="user")
public class User{

    @Id
    @Column(name ="USER_ID", insertable =false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId ;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "USER_LOGIN")
    private String userLogin;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_POSITION")
    private String userPosition;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Time> userTime;

    @Column(name = "USER_ROLE")
    private String userRole;

    public User() {
    }

    public User(String userLogin, String userPassword, String userName, String userLastName, String userPosition, String userRole) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userPosition = userPosition;
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return userId;
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

    public List<Time> getUserTime() {
        return userTime;
    }

    public void setUserTime(List<Time> userTime) {
        this.userTime = userTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {

        return "id: " + this.userId + ", name: " +  this.userName
                + " " + this.userLastName + ", position: " +  this.userPosition;
    }
}
