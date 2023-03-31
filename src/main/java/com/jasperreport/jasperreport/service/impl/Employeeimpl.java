package com.jasperreport.jasperreport.service.impl;

import com.jasperreport.jasperreport.entity.Employee;
import com.jasperreport.jasperreport.repository.EmployeeRepo;
import com.jasperreport.jasperreport.service.Employeeservice;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Employeeimpl implements Employeeservice {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee saveEmployee(Employee emp) {
        return this.employeeRepo.save(emp);

    }

    @Override
    public List<Employee> getAllEmployee() {
        this.employeeRepo.findAll();
        return this.employeeRepo.findAll();
    }

    @Override
    public String exportrept(String reportFormat) throws FileNotFoundException, JRException {
        String path = "F:\\Bikkadit\\Assignment_Task";
        List<Employee> employees = this.employeeRepo.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Isha Rathore");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }
        if (reportFormat.equalsIgnoreCase("xml")) {
            JasperExportManager.exportReportToXmlFile(jasperPrint,path + "\\employees.xls",true);
        }

        return "report generated in path : " + path;

    }
}
