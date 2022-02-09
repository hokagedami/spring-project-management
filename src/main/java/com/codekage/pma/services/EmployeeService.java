package com.codekage.pma.services;

import com.codekage.pma.dao.IEmployeeRepository;
import com.codekage.pma.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    final
    IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> GetAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee AddNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee GetEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
