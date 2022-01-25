package com.codekage.pma.dao;

import com.codekage.pma.dto.ProjectStatusCount;
import com.codekage.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    String projectStatusCountQuery = "select stage as projectStatus, count(*) as count from project group by stage";

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = projectStatusCountQuery)
    List<ProjectStatusCount> getStatusCount();
}
