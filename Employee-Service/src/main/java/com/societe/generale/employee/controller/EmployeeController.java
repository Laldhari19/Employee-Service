package com.societe.generale.employee.controller;

import com.societe.generale.employee.dto.EmployeeDTO;
import com.societe.generale.employee.repository.entity.Employee;
import com.societe.generale.employee.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee-service/v1/")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Create new employee data")
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("employee")
    public Employee createEmployee(@RequestBody @Validated EmployeeDTO employeeDTO){
        log.info("createEmployee Method Request Object {}",employeeDTO);
         return employeeService.createNewEmployee(employeeDTO);
    }

    @ApiOperation(value = "Publishes all available employee")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getExistingEmployee();
    }
}
