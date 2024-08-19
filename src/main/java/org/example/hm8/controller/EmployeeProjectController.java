package org.example.hm8.controller;

import org.example.hm8.model.EmployeeProject;
import org.example.hm8.service.EmployeeProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/employee-projects")
@Tag(name = "EmployeeProjectController",
        description = "API для управления проектами сотрудников")
public class EmployeeProjectController {

    private final EmployeeProjectService employeeProjectService;

    public EmployeeProjectController(EmployeeProjectService employeeProjectService) {
        this.employeeProjectService = employeeProjectService;
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @PostMapping
    public ResponseEntity<EmployeeProject> addEmployeeToProject(@RequestBody Map<String, Long> request) {
        Long employeeId = request.get("employeeId");
        Long projectId = request.get("projectId");

        if (employeeId == null || projectId == null) {
            return ResponseEntity.badRequest().build();
        }

        EmployeeProject createdEmployeeProject = employeeProjectService.addEmployeeToProject(employeeId, projectId);

        return ResponseEntity.ok(createdEmployeeProject);
    }
}


