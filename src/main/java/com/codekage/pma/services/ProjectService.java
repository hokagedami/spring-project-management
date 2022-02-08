package com.codekage.pma.services;

import com.codekage.pma.dao.IEmployeeRepository;
import com.codekage.pma.dao.IProjectRepository;
import com.codekage.pma.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    final
    IProjectRepository projectRepository;

    final
    IEmployeeRepository employeeRepository;

    public ProjectService(IProjectRepository projectRepository, IEmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Project> GetAllProjects(){
        return projectRepository.findAll();
    }

    public void AddNewProject(Project project) {
        projectRepository.save(project);
    }
}
