package com.example.manytomany.manytomany.serviceImpl;

import com.example.manytomany.manytomany.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeImpl {
    Employee saveEmployee(Employee employee);
    List<Employee> saveEmployees(List<Employee> employee);

    List<Employee> getEployees();
    List<Employee> getEployees(String field);
    Optional<Employee> getEmployeeById(int id);
    void deleteEmployeeById(int id);
    Employee assignProjectToEmployee(int empId, int projectId);
}
