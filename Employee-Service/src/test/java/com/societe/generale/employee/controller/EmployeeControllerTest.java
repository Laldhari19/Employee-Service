package com.societe.generale.employee.controller;

import com.societe.generale.employee.dto.EmployeeDTO;
import com.societe.generale.employee.repository.entity.Employee;
import com.societe.generale.employee.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @Captor
    ArgumentCaptor<EmployeeDTO> employeeArgumentCaptor;

    @Test
    public void createEmployeeTest(){
        EmployeeDTO employeeDTO= EmployeeDTO.builder().dateOfBirth(new Date()).department("Tech").firstName("Tom")
                .lastName("Mishra").gender("Male").build();
        employeeController.createEmployee(employeeDTO);
        Mockito.verify(employeeService).createNewEmployee(employeeArgumentCaptor.capture());
        Assert.assertEquals(employeeDTO,employeeArgumentCaptor.getValue());
    }

    @Test
    public void getAllEmployeeTest(){
        List<Employee> employees= Arrays.asList(Employee.builder().name("Tom Harry").department("Manager").
                dateOfBirth(new Date()).gender("Female").build());
        when(employeeService.getExistingEmployee()).thenReturn(employees);
        List<Employee> response=employeeController.getAllEmployee();
        Assert.assertEquals(employees,response);
    }
}
