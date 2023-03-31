package com.jasperreport.jasperreport.repository;

import com.jasperreport.jasperreport.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
