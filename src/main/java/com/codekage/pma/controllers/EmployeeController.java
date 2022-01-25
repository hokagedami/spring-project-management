package com.codekage.pma.controllers;

import com.codekage.pma.dao.IEmployeeRepository;
import com.codekage.pma.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    final
    IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String displayEmployees(Model model){

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){

        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee){
        // return "Saved";
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
}
