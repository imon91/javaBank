package com.craftcode.demo.service;

import com.craftcode.demo.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    String createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeDetail(Long id);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployeeInfo(Long id, EmployeeDto employeeDto);

    void deleteEmp(Long id);
}
