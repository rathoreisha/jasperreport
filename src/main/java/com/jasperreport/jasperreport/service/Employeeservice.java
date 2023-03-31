package com.jasperreport.jasperreport.service;

import com.jasperreport.jasperreport.entity.Employee;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface Employeeservice {

    Employee saveEmployee(Employee emp);

    List<Employee> getAllEmployee();

    String exportrept(String reportformat) throws FileNotFoundException, JRException;
}
