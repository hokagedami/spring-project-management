package com.codekage.pma.controllers;

import com.codekage.pma.entities.Employee;
import com.codekage.pma.services.EmployeeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String displayEmployees(@NotNull Model model){

        List<Employee> employees = employeeService.GetAllEmployees();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(@NotNull Model model){

        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);

        List<Employee> employees = employeeService.GetAllEmployees();
        model.addAttribute("employees", employees);

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee){
        // return "Saved";
        employeeService.AddNewEmployee(employee);
        return "redirect:/employees";
    }
}
