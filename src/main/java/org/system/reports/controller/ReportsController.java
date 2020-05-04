package org.system.reports.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.system.admin.model.User;
import org.system.admin.repository.UserRepository;
import org.system.reports.service.UserReportService;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class ReportsController {

    @Autowired
    private UserReportService userReportService;

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return userReportService.exportReport(format);
    }

}
