package com.codekage.pma.controllers;

import com.codekage.pma.dao.IEmployeeRepository;
import com.codekage.pma.dao.IProjectRepository;
import com.codekage.pma.entities.Employee;
import com.codekage.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @GetMapping
    public String DisplayHome(Model model){
          List<Project> projects = projectRepository.findAll();
          model.addAttribute("projects", projects);

          List<Employee> employees = employeeRepository.findAll();
          model.addAttribute("employees", employees);

          return "main/home";
    }
}
