package com.example.manytomany.manytomany.service;
import com.example.manytomany.manytomany.entity.Employee;
import com.example.manytomany.manytomany.entity.Project;
import com.example.manytomany.manytomany.repository.EmployeeRepo;
import com.example.manytomany.manytomany.repository.ProjectRepo;
import com.example.manytomany.manytomany.serviceImpl.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService implements EmployeeImpl {
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);

    }

    @Override
    public List<Employee> saveEmployees(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    @Override
    public List<Employee> getEployees() {
        return repo.findAll();
    }

    @Override
    public List<Employee> getEployees(String field) {
        return repo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return repo.findById(id);
    }

    @Override
    public void deleteEmployeeById(int id) {
repo.deleteById(id);
        System.out.println("Employee Deleted");
    }


    public Employee assignProjectToEmployee(int empId, int projectId) {
       Set<Project> projectSet=null;
        Employee employee=repo.findById(empId).get();
        Project project=projectRepo.findById(projectId).get();
        projectSet=employee.getAssignedProjects();
        projectSet.add(project);
        employee.setAssignedProjects(projectSet);
       return repo.save(employee);

    }
}
