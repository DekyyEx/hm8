package org.example.hm8.service;

import org.example.hm8.repository.EmployeeProjectRepository;
import org.example.hm8.repository.EmployeeRepository;
import org.example.hm8.repository.ProjectRepository;
import org.example.hm8.model.Employee;
import org.example.hm8.model.EmployeeProject;
import org.example.hm8.model.Project;
import org.springframework.stereotype.Service;


@Service
public class EmployeeProjectService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeProjectRepository employeeProjectRepository;

    public EmployeeProjectService(EmployeeRepository employeeRepository, ProjectRepository projectRepository,
                                  EmployeeProjectRepository employeeProjectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.employeeProjectRepository = employeeProjectRepository;
    }

    public EmployeeProject addEmployeeToProject(Long employeeId, Long projectId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + employeeId + " not found"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project with id " + projectId + " not found"));

        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);

        return employeeProjectRepository.save(employeeProject);
    }
}

