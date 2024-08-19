package org.example.hm8.controller;

import org.example.hm8.model.Employee;
import org.example.hm8.model.Project;
import org.example.hm8.model.Timesheet;
import org.example.hm8.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee Controller",
        description = "Контроллер для работы с сотрудниками")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Получение всех сотрудников",
            description = "Получение всех сотрудников из БД")
    @API.Found
    @API.ServerError
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @Operation(summary = "Получение сотрудника по ID",
            description = "Получение сотрудника по его ID из БД")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@Parameter(description = "id сотрудника") @PathVariable Long id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @Operation(summary = "Получение списка проектов по ID сотрудника",
            description = "Получение списка проетов по ID сотрудника из БД")
    @GetMapping("/{id}/projects")
    public ResponseEntity<List<Project>> getEmployeeProjects(@Parameter(description = "id сотрудника") @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeProjects(id));
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @Operation(summary = "Получение списка таймшитов по ID сотрудника",
            description = "Получение списка таймшитов по ID сотрудника из БД")
    @GetMapping("/{id}/timesheets")
    public ResponseEntity<List<Timesheet>> getEmployeeTimesheets(@Parameter(description = "id сотрудника")
                                                                     @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeTimesheets(id));
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @Operation(summary = "Получение сотрудника по имени",
            description = "Получение сотрудника по имени из БД")
    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@Parameter(description = "имя сотрудника")
                                                          @PathVariable String name) {
        return employeeService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Создание сотрудника",
            description = "Создание сотрудника в БД")
    @API.Found
    @API.ServerError
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @Operation(summary = "Удаление сотрудника по ID",
            description = "Удаление сотрудника по ID из БД")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@Parameter(description = "id сотрудника") @PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

