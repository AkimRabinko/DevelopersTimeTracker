package com.mycompany.developerstimetracker.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AkimPC on 31.07.2016.
 */
@Entity
@Table(name = "user_project")
public class UserProject {

    @Id
    @Column(name ="USER_PROJECT_ID", insertable =false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userProjectId;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Project project;

    public Integer getUserProjectId() {
        return userProjectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
