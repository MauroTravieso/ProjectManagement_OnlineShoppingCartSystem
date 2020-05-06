package org.system.reports.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.system.admin.model.User;
import org.system.admin.repository.UserRepository;
import org.system.product.model.Product;
import org.system.product.repository.ProductRepository;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reports Controller.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Jean Octavius ()
 * @version      1.0
 *
 */
@Service
public class ProductReportService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ServletContext servletContext;

    public String exportReport() throws FileNotFoundException, JRException {

        //String path1 = "classpath:generateReport\\userReport";
        //String path2="C:\\Users\\vocsi\\Downloads\\ProjectManagement_OnlineShoppingCartSystem-master\\src\\main\\resources\\generateReport\\userReport.pdf";
        String path = "/home/mauro/MUM/10A-Project Management/Project/OnlineShoppingCartSystem/productReport.pdf";
        List<Product> products = productRepository.findAll();

        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/productReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Team II");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path);
        // }

        return "report generated in path : " + path;
    }

    public String exportReportByVendor() throws FileNotFoundException, JRException {

        //String path1 = "classpath:generateReport\\userReport";
        //String path2="C:\\Users\\vocsi\\Downloads\\ProjectManagement_OnlineShoppingCartSystem-master\\src\\main\\resources\\generateReport\\userReport.pdf";
        String path = "/home/mauro/MUM/10A-Project Management/Project/OnlineShoppingCartSystem/productByVendorReport.pdf";
        List<Product> products = productRepository.findAll();

        //load file and compile it
        File file = ResourceUtils.getFile("classpath:reports/productByVendorReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Team II");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path);
        // }

        return "report generated in path : " + path;
    }
}
