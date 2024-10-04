package com.example.ManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ManagementTool.Entity.ProjectDetails;

@Repository
public interface ProjectDetailsRepo extends JpaRepository<ProjectDetails, Integer> {

	ProjectDetails findByProjectId(int projectid);

	@Query("SELECT MAX(p.projectId) FROM ProjectDetails p")
	Integer findMaxProjectId();

}
