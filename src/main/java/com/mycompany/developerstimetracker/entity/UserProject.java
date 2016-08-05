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
    private Integer userProjectId;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> project;

    public Integer getUserProjectId() {
        return userProjectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
