package org.example.hm8.controller;

import org.example.hm8.model.Timesheet;
import org.example.hm8.service.TimesheetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/timesheets")
@Tag(name = "TimesheetController",
        description = "Контроллер для работы с табелями")
public class TimesheetController {

    private final TimesheetService service;

    public TimesheetController(TimesheetService service) {
        this.service = service;
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @Operation(summary = "Получение табеля по ID",
            description = "Получение табеля по его ID из БД")
    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> getTimesheetById(@Parameter(description = "id табеля") @PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @API.Found
    @API.ServerError
    @Operation(summary = "Получение всех табелей",
            description = "Получение всех табелей из БД")
    @GetMapping
    public ResponseEntity<List<Timesheet>> getAllTimesheets(
            @Parameter(description = "createdAtBefore дата создания до") @RequestParam(required = false) LocalDate createdAtBefore,
            @Parameter(description = " createdAtAfter дата создания после") @RequestParam(required = false) LocalDate createdAtAfter
    ) {
        return ResponseEntity.ok(service.findAll(createdAtBefore, createdAtAfter));
    }


    @PostMapping
    @API.Found
    @API.ServerError
    @Operation(summary = "Создание табеля",
            description = "Создание табеля и добавление БД")
    public ResponseEntity<Timesheet> create(@Parameter(name = "timesheet", description = "Табель") @RequestBody Timesheet timesheet) {
        final Timesheet created = service.create(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @PutMapping
    @Operation(summary = "Изменение табеля по id",
            description = "Изменение табеля по id и обновление БД")
    public ResponseEntity<Timesheet> update(@Parameter(description = "id табеля") @PathVariable Long id, @Parameter(name = "timesheet", description = "Табель") @RequestBody Timesheet timesheet) {
        return service.update(id, timesheet)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @API.Found
    @API.NotFound
    @API.ServerError
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление табеля по id",
            description = "Удаление табеля по id и обновление БД")
    public ResponseEntity<Void> delete(@Parameter(description = "id табеля") @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }
}
