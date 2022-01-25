package com.codekage.pma.controllers;

import com.codekage.pma.dao.IEmployeeRepository;
import com.codekage.pma.dao.IProjectRepository;
import com.codekage.pma.entities.Employee;
import com.codekage.pma.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    final
    IProjectRepository projectRepository;

    final
    IEmployeeRepository employeeRepository;

    public ProjectController(IProjectRepository projectRepository, IEmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String displayProjects(Model model){

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){

        Project newProject = new Project();
        model.addAttribute("project", newProject);

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Project project){
        // return "Saved";
        projectRepository.save(project);
        return "redirect:/projects";
    }
}
