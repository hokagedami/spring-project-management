package com.codekage.pma.dao;

import com.codekage.pma.entities.Employee;
import com.codekage.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
