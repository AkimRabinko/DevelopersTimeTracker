package com.mycompany.developerstimetracker.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by AkimPC on 29.06.2016.
 */

@Entity
@Table(name="user_time")
public class Time {


    @Id
    @Column(name ="TIME_ID", insertable =false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timeId;

    @Column(name = "TIME")
    private Integer time;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_TIME")
    private Date date;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    public Time() {
    }

    public Time(Integer time, String description, Date date) {
        this.time = time;
        this.description = description;
        this.date = date;
    }

    public int getTimeId() {
        return timeId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(Integer time) {
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

    @Override
    public String toString() {
        return "Time{" +
                "description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}
