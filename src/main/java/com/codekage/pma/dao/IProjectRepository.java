package com.codekage.pma.dao;

import com.codekage.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();
}
