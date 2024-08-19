package org.example.hm8.service;


import org.example.hm8.repository.EmployeeRepository;
import org.example.hm8.model.Employee;
import org.example.hm8.model.Project;
import org.example.hm8.model.Timesheet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private Employee findProjectOrThrow(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project with id " + id + " does not exist"));
    }

    public Optional<Employee> findById(Long id) {
        findProjectOrThrow(id);
        return employeeRepository.findByEmployeeId(id);
    }


    public Optional<Employee> findByName(String name) {
        return Optional.ofNullable(employeeRepository.findByEmployeeName(name)
                .orElseThrow(() -> new NoSuchElementException("Project with name " + name + " does not exist")));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {

        if (employeeRepository.findByEmployeeName(employee.getEmployeeName()).isPresent()) {
            throw new IllegalArgumentException("Project with name " + employee.getEmployeeName() + " already exists");
        }

        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        findProjectOrThrow(id);
        employeeRepository.deleteById(id);
    }

    public List<Project> findEmployeeProjects(Long id) {
        findProjectOrThrow(id);
        return employeeRepository.findEmployeeProjects(id);
    }

    public List<Timesheet> findEmployeeTimesheets(Long id) {
        findProjectOrThrow(id);
        return employeeRepository.findEmployeeTimesheets(id);
    }
}
