package com.codekage.pma.dao;

import com.codekage.pma.dto.EmployeeProject;
import com.codekage.pma.entities.Employee;
import com.codekage.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    String employeeProjectsQuery = "select e.first_name as firstName, e.last_name as lastName, count(pe.employee_id) "+
            "as totalProjects from employee e left join project_employee pe on pe.employee_id = e.employee_id group by"+
            " e.first_name, e.last_name order by 3 desc";

    @Override
    public List<Employee> findAll();
    @Query(nativeQuery = true, value = employeeProjectsQuery)
    public List<EmployeeProject> employeeProjects();
}
