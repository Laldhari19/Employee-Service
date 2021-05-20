package com.societe.generale.employee.service;

import com.societe.generale.employee.dto.EmployeeDTO;
import com.societe.generale.employee.repository.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createNewEmployee(EmployeeDTO employeeDTO);
    List<Employee> getExistingEmployee();
}
