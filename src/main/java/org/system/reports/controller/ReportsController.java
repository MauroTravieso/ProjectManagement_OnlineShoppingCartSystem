package org.system.reports.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.system.admin.model.User;
import org.system.admin.repository.UserRepository;
import org.system.reports.service.OrderReportService;
import org.system.reports.service.ProductReportService;
import org.system.reports.service.UserReportService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Reports Controller.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Jean Octavius ()
 * @version      1.0
 *
 */

@Controller
public class ReportsController {

    @Autowired
    private UserReportService userReportService;

    @Autowired
    private ProductReportService productReportService;

    @Autowired
    private OrderReportService orderReportService;

    @GetMapping("/userReport")
    public String userReport(HttpServletRequest request) throws FileNotFoundException, JRException {
        return userReportService.exportReport();
    }

    @GetMapping("/productReport")
    public String productReport(HttpServletRequest request) throws FileNotFoundException, JRException {
        return productReportService.exportReport();
    }

    @GetMapping("/productByVendorReport")
    public String productByVendorReport(HttpServletRequest request) throws FileNotFoundException, JRException {
        return productReportService.exportReportByVendor();
    }

    @GetMapping("/orderReport")
    public String orderReport(HttpServletRequest request) throws FileNotFoundException, JRException {
        return orderReportService.exportReport();
    }

    @GetMapping("/orderReport/{email}")
    public String orderReport(@PathVariable String email) throws FileNotFoundException, JRException {
        return orderReportService.exportReport(email);
    }


}
