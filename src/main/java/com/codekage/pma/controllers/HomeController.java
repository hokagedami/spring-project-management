package com.codekage.pma.controllers;

import com.codekage.pma.dao.IEmployeeRepository;
import com.codekage.pma.dao.IProjectRepository;
import com.codekage.pma.dto.EmployeeProject;
import com.codekage.pma.dto.ProjectStatusCount;
import com.codekage.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String applicationVersion;

    final
    IProjectRepository projectRepository;

    final
    IEmployeeRepository employeeRepository;

    public HomeController(IProjectRepository projectRepository, IEmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String DisplayHome(Model model) throws JsonProcessingException {
          List<Project> projects = projectRepository.findAll();
          model.addAttribute("projects", projects);

          List<EmployeeProject> employeeProjectsCount = employeeRepository.employeeProjects();
          model.addAttribute("employeesProjectCount", employeeProjectsCount);

        List<ProjectStatusCount> projectData = projectRepository.getStatusCount();
        ObjectMapper objectMapper = new ObjectMapper();
        String projectDataJsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCount", projectDataJsonString);

        model.addAttribute("applicationVersion", applicationVersion);

          return "main/home";
    }
}
