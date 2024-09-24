package com.example.manytomany.manytomany.serviceImpl;

import com.example.manytomany.manytomany.entity.Employee;
import com.example.manytomany.manytomany.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectImpl {
    void saveProject(Project project);
    List<Project> saveProjects(List<Project> projects);
    List<Project> getProjects();
    List<Project> findProject(String field);
    Optional<Project> getProjectById(int id);
    void deleteProjectById(int id);
}
