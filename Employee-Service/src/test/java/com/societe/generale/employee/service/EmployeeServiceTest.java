package com.societe.generale.employee.service;


import com.societe.generale.employee.dto.EmployeeDTO;
import com.societe.generale.employee.repository.EmployeeRepository;
import com.societe.generale.employee.repository.entity.Employee;
import com.societe.generale.employee.service.impl.EmployeeServiceImpl;
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
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Captor
    ArgumentCaptor<Employee> employeeArgumentCaptor;

    @Test
    public void createNewEmployeeTestPositive(){
        EmployeeDTO employeeDTO= EmployeeDTO.builder().dateOfBirth(new Date()).department("Tech").firstName("Laldhari")
                .lastName("Prasad").gender("Male").build();
        employeeService.createNewEmployee(employeeDTO);
        Mockito.verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Assert.assertEquals("Laldhari Prasad",employeeArgumentCaptor.getValue().getName());
    }

    @Test
    public void createNewEmployeeTestNegative(){
        EmployeeDTO employeeDTO= EmployeeDTO.builder().dateOfBirth(new Date()).department("Tech").firstName("Laldhari")
                .lastName("Prasad").gender("Male").build();
        employeeService.createNewEmployee(employeeDTO);
        Mockito.verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Assert.assertNotEquals("Laldhari",employeeArgumentCaptor.getValue().getName());
    }

    @Test
    public void getExistingEmployeeTest(){
        List<Employee> employees= Arrays.asList(Employee.builder().name("Tom Harry").department("Manager").
                dateOfBirth(new Date()).gender("Female").build());
        when(employeeRepository.findAllByOrderByNameAsc()).thenReturn(employees);
        List<Employee> response=employeeService.getExistingEmployee();
        Assert.assertEquals(employees,response);

    }

}
