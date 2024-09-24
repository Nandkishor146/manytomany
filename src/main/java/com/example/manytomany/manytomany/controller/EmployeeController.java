package com.example.manytomany.manytomany.controller;

import com.example.manytomany.manytomany.entity.Employee;
import com.example.manytomany.manytomany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PostMapping("addEmployee")
public Employee addEmployee(@RequestBody Employee employee )
{
return service.saveEmployee(employee);
}
    @PostMapping("addAllEmployee")
    public List<Employee> addEmployees(@RequestBody List<Employee>employees)
    {
        return service.saveEmployees(employees);
    }
@GetMapping("getAllEmployee")
public List<Employee> findAllEmployee()
{
    return service.getEployees();
}
@GetMapping("GetEmployeeById/{id}")
public Optional<Employee> getEmployeeById(@PathVariable int id)
{
    return service.getEmployeeById(id);
}
@GetMapping("sortByfield/{field}")
public List<Employee> sortEmplyeeByfield(@PathVariable String field)
{
    return service.getEployees(field);
}
@DeleteMapping("deleteEmployeeById/{id}")
public void deleteEmployeeById(@PathVariable int id)
{
    service.deleteEmployeeById(id);
}
@PutMapping("/{empId}/project/{projectId}")
    public Employee assignProjectToEmployee(@PathVariable  int empId,@PathVariable int projectId)
{
    return service.assignProjectToEmployee(empId,projectId);
}
}
