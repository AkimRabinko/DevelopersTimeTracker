package com.mycompany.developerstimetracker.dto;

import com.mycompany.developerstimetracker.entity.User;

import java.sql.Date;


/**
 * Created by AkimPC on 09.07.2016.
 */
public class TimeTO {

    private int time;
    private String description;
    private Date date;
    private User user;

    public  TimeTO() {

    }

    public TimeTO(int time, String description, Date date) {
        this.time = time;
        this.description = description;
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
