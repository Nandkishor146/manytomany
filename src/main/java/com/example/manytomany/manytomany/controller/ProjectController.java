package com.example.manytomany.manytomany.controller;

import com.example.manytomany.manytomany.entity.Employee;
import com.example.manytomany.manytomany.entity.Project;
import com.example.manytomany.manytomany.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService service;
@PostMapping("addProject")
    public void addProject(@RequestBody Project project )
    {
        service.saveProject(project);
    }
    @PostMapping("addAllProjects")
    public List<Project> addProjects(List<Project> projects)
    {
        return service.saveProjects(projects);
    }
    @GetMapping("getAllProject")
    public List<Project> findAllProject()
    {
        return service.getProjects();
    }
    public List<Project> findProject(@PathVariable String field) {
        List<Project> projects=service.findProject(field);
        return projects;
        }

    @GetMapping("GetProjectById/{id}")
    public Optional<Project> getProjectById(@PathVariable int id)
    {
        return service.getProjectById(id);
    }
    @DeleteMapping("deleteProjectById/{id}")
    public void deleteProjectById(@PathVariable int id)
    {
        service.deleteProjectById(id);
    }

}
