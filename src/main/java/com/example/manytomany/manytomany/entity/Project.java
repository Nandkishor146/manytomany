package com.example.manytomany.manytomany.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<Employee> employees=new HashSet<>();

    public Project() {
    }

    public Project(int projectId, String projectName, Set<Employee> employees) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
