package org.example.hm8.service;

import org.example.hm8.model.Timesheet;

import java.util.Optional;

public class ProxyTimesheetService extends TimesheetService {


    private final TimesheetService timesheetService;

    public ProxyTimesheetService(TimesheetService timesheetService) {
        super(timesheetService);
        this.timesheetService = timesheetService;
    }

    @Override
    public Optional<Timesheet> findById(Long id) {
        Optional<Timesheet> result = null;
        try {
            result = timesheetService.findById(id);
        } catch (Throwable e) {
            throw e;
        } finally {
            return result;
        }

    }
}
