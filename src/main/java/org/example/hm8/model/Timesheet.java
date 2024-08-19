package org.example.hm8.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "timesheet_id")
    private Long timesheetId;

    @Column(name = "timesheet_project_id")
    private Long timesheetProjectId;

    @Column(name = "timesheet_employee_id")
    private Long timesheetEmployeeId;

    @Column(name = "minutes")
    private Integer minutes;

    @Column(name = "created_at")
    private LocalDate createdAt;

}
