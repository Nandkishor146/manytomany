package com.example.manytomany.manytomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> assignedProjects=new HashSet<>();

    public Employee() {
    }

    public Employee(int empId, String empName, Set<Project> assignedProjects) {
        this.empId = empId;
        this.empName = empName;
        this.assignedProjects = assignedProjects;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Set<Project> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(Set<Project> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", assignedProjects=" + assignedProjects +
                '}';
    }
}
