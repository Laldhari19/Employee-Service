package com.societe.generale.employee.service.impl;

import com.societe.generale.employee.dto.EmployeeDTO;
import com.societe.generale.employee.repository.EmployeeRepository;
import com.societe.generale.employee.repository.entity.Employee;
import com.societe.generale.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createNewEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(Employee.builder().name(employeeDTO.getFirstName().concat(" ").
                concat(employeeDTO.getLastName())).dateOfBirth(employeeDTO.getDateOfBirth()).
                gender(employeeDTO.getGender()).department(employeeDTO.getDepartment()).build());
    }

    @Override
    public List<Employee> getExistingEmployee() {
        return employeeRepository.findAllByOrderByNameAsc();
    }
}
