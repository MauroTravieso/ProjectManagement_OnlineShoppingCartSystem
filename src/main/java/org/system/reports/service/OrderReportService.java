package org.system.reports.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.system.payment.model.Order;
import org.system.payment.repository.OrderRepository;
import org.system.product.model.Product;
import org.system.product.repository.ProductRepository;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OrderReports Service.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Jean Octavius ()
 * @version      1.0
 *
 */

@Service
public class OrderReportService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ServletContext servletContext;



    public String exportReport() throws FileNotFoundException, JRException {

        //String path1 = "classpath:generateReport\\userReport";
        //String path2="C:\\Users\\vocsi\\Downloads\\ProjectManagement_OnlineShoppingCartSystem-master\\src\\main\\resources\\generateReport\\userReport.pdf";
        String path = "/home/mauro/MUM/10A-Project Management/Project/OnlineShoppingCartSystem/orderReport.pdf";
        List<Order> orders = (List) orderRepository.findAll();

        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/orderReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Team II");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path);
        // }

        return "report generated in path : " + path;
    }

    public String exportReport(String email) throws FileNotFoundException, JRException {

        //String path1 = "classpath:generateReport\\userReport";
        //String path2="C:\\Users\\vocsi\\Downloads\\ProjectManagement_OnlineShoppingCartSystem-master\\src\\main\\resources\\generateReport\\userReport.pdf";
        String path = "/home/mauro/MUM/10A-Project Management/Project/OnlineShoppingCartSystem/orderReport.pdf";
        List<Order> orders = (List) orderRepository.findByEmail(email);

        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/orderReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Team II");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path);
        // }

        return "report generated in path : " + path;
    }

}
