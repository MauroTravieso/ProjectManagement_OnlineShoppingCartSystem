package org.system.reports.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.system.admin.model.User;
import org.system.admin.repository.UserRepository;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ServletContext servletContext;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
//        String path = servletContext.getRealPath("/");
//        System.out.println(path);

        String path = "/home/mauro/MUM/10A-Project Management/Project/OnlineShoppingCartSystem/";
        List<User> users = userRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/userReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Team II");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "users.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "users.pdf");
        }

        return "report generated in path : " + path;
    }
}
