package com.jasperreport.jasperreport.controller;

import com.jasperreport.jasperreport.entity.Employee;
import com.jasperreport.jasperreport.service.Employeeservice;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private Employeeservice employeeservice;

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
    {
        Employee employee = this.employeeservice.saveEmployee(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> allEmployee = this.employeeservice.getAllEmployee();
        return new ResponseEntity<>(allEmployee,HttpStatus.OK);
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException, JRException, FileNotFoundException {
        return this.employeeservice.exportrept(format);
    }

}
