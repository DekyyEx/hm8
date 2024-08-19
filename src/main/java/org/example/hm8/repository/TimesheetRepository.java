package org.example.hm8.repository;

import org.example.hm8.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {


    List<Timesheet> findAllByTimesheetEmployeeId(Long employeeId);

    List<Timesheet> findAllByTimesheetProjectId(Long employeeId);


    List<Timesheet> findByCreatedAtBetween(LocalDate min, LocalDate max);

}
