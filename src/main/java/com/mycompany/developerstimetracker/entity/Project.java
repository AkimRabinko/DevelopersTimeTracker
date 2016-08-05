package com.mycompany.developerstimetracker.entity;

import javax.persistence.*;

/**
 * Created by AkimPC on 31.07.2016.
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name ="PROJECT_ID", insertable =false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    public Project() {

    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectId() {
        return projectId;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
