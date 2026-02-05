package com.craftcode.demo.service.impl;

import com.craftcode.demo.config.ModelConfig;
import com.craftcode.demo.dto.EmployeeDto;
import com.craftcode.demo.entity.Employee;
import com.craftcode.demo.repository.EmployeeRepo;
import com.craftcode.demo.service.EmployeeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public String createEmployee(EmployeeDto employeeDto) {
        employeeRepo.save(modelMapper.map(employeeDto, Employee.class));
        return "test";

    }

    @Override
    public EmployeeDto getEmployeeDetail(Long id) {
       Employee employee =  employeeRepo.findById(id).orElse(null);
       EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
       return employeeDto;



    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List <Employee> employeeLists=employeeRepo.findAll();
        return employeeLists.stream().map(employee->modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());


    }

    @Override
    public EmployeeDto updateEmployeeInfo(Long id, EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setActive(employee.isActive());
        employee.setId(id);
        Employee employee1 = employeeRepo.save(employee);
        return modelMapper.map(employee1,EmployeeDto.class);

    }
    public boolean deleteEmployeeId(Long id){
        boolean exits = employeeRepo.existsById(id);
        if(! exits) return false;
        employeeRepo.deleteById(id);
        return true;


    }

    @Override
    public void deleteEmp(Long id) {

        boolean status = deleteEmployeeId(id);

    }
}
