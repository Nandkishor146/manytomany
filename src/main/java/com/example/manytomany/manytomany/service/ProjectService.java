package com.example.manytomany.manytomany.service;

import com.example.manytomany.manytomany.entity.Project;
import com.example.manytomany.manytomany.repository.ProjectRepo;
import com.example.manytomany.manytomany.serviceImpl.ProjectImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectImpl {
    @Autowired
    private ProjectRepo repo;

    public void saveProject(Project project)
    {
        repo.save(project);
    }

    @Override
    public List<Project> saveProjects(List<Project> projects) {
        return repo.saveAll(projects);
    }

    public List<Project> getProjects()
    {
       return repo.findAll();
    }

    @Override
    public List<Project> findProject(String field) {
        return repo.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Optional<Project> getProjectById(int id)
    {
        return repo.findById(id);
    }

    public void deleteProjectById(int id)
    {
        repo.deleteById(id);
        System.out.println("Project Deleted");
    }

}
