package org.example.hm8.pages;

import org.example.hm8.service.TimesheetPageService;
import org.example.hm8.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetPageController {

    private final TimesheetPageService service;

    @GetMapping
    public String getAllTimesheets(Model model) {
        List<TimeSheetPageDto> timesheets = service.findAll();
        model.addAttribute("timesheets", timesheets);
        return "timesheets-page";
    }

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {
        Optional<TimeSheetPageDto> timesheetOpt = service.findById(id);
        if (timesheetOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        model.addAttribute("timesheet", timesheetOpt.get());
        return "timesheet-page";
    }

    @GetMapping("/project/{projectId}")
    public String getProjectPage(@PathVariable Long projectId, Model model) {
        System.out.println("Received request for projectId: " + projectId);
        Optional<Project> projectOpt = service.findProjectById(projectId);
        if (projectOpt.isEmpty()) {
            System.out.println("Project not found for projectId: " + projectId);
            throw new NoSuchElementException();
        }

        model.addAttribute("project", projectOpt.get());
        return "project-page";
    }
}



