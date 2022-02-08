package com.codekage.pma.controllers;

import com.codekage.pma.entities.Employee;
import com.codekage.pma.entities.Project;
import com.codekage.pma.services.EmployeeService;
import com.codekage.pma.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    final ProjectService projectService;

    final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String displayProjects(Model model){

        List<Project> projects = projectService.GetAllProjects();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){

        Project newProject = new Project();
        model.addAttribute("project", newProject);

        List<Employee> employees = employeeService.GetAllEmployees();
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Project project){
        // return "Saved";
        projectService.AddNewProject(project);
        return "redirect:/projects";
    }
}
