package com.codekage.pma.api.controllers;

import com.codekage.pma.entities.Employee;
import com.codekage.pma.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees", method = {RequestMethod.GET, RequestMethod.POST})
public class EmployeeApiController {

    final EmployeeService employeeService;

    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.AddNewEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.GetAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.GetEmployeeById(id);
    }
}
