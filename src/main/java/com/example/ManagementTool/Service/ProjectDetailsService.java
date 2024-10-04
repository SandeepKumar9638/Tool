package com.example.ManagementTool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.ManagementTool.Entity.ProjectDetails;
import com.example.ManagementTool.Repository.ProjectDetailsRepo;

@Service
public class ProjectDetailsService {

	@Autowired
	ProjectDetailsRepo projectDetailsRepo;

	@Value("${idStartsWithNum}")
	private int idStartsWithNum;

	public ProjectDetails postProjectDetails(ProjectDetails projectDetails) {
		int nextId = calculateNextId();

		projectDetails.setProjectId(nextId);
		return projectDetailsRepo.save(projectDetails);
	}

	private int calculateNextId() {

		Integer maxId = projectDetailsRepo.findMaxProjectId();
		if (maxId == null || maxId < idStartsWithNum) {
			return idStartsWithNum;
		} else {
			return maxId + 1;
		}
	}

	public List<ProjectDetails> getAllProjectDetails() {
		return projectDetailsRepo.findAll();
	}

	public Optional<ProjectDetails> getProjectDetailsById(int projectId) {
		return projectDetailsRepo.findById(projectId);
	}

	public ProjectDetails updateProjectDetails(ProjectDetails projectDetails, int projectId) {
		return projectDetailsRepo.save(projectDetails);
	}

	public String deleteProjectDetails(int projectId) {

		ProjectDetails project = projectDetailsRepo.findByProjectId(projectId);
		if (project != null) {
			projectDetailsRepo.delete(project);
		}
		return "deleted";
	}

}
