package com.craftcode.demo.controller;

import com.craftcode.demo.dto.EmployeeDto;
import com.craftcode.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/getEmployeeDetail/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id){
       EmployeeDto employeeDto = employeeService.getEmployeeDetail(id);
       return employeeDto;

    }
    @GetMapping("/findAll")
    public List<EmployeeDto> getAllEmployeeList(){
       List<EmployeeDto>  employeeDto = employeeService.getAllEmployee();
       return employeeDto;


    }

    @PostMapping("/registration")
    public String createEmployeeDetail(@RequestBody EmployeeDto employeeDto){
        String test = employeeService.createEmployee(employeeDto);
        return "success";

    }
    @PutMapping("/updateEmployee/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
       EmployeeDto eDto =  employeeService.updateEmployeeInfo(id, employeeDto);
       return eDto;

    }

    @DeleteMapping("/deleteEmployee/{id}")

    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmp(id);
        return "deleted";


    }







}
