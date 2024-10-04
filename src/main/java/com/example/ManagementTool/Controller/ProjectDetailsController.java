package com.example.ManagementTool.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManagementTool.Entity.ProjectDetails;
import com.example.ManagementTool.Service.ProjectDetailsService;

@RestController
public class ProjectDetailsController {
	
	@Autowired
	ProjectDetailsService projectDetailsService;
	
	
	
	@PostMapping("/postProjectDetails")
	public ProjectDetails postProjectDetails(@RequestBody ProjectDetails projectDetails) {
		return projectDetailsService.postProjectDetails(projectDetails);
	}

	@GetMapping("/getAllProjectDetails")
	public List<ProjectDetails> getAllProjectDetails() {
		return projectDetailsService.getAllProjectDetails();
	}

	@GetMapping("/getAllProjectDetails/{projectId}")
	public Optional<ProjectDetails> getProjectDetailsById(@PathVariable int projectId) {
		return projectDetailsService.getProjectDetailsById(projectId);
	}

	@PutMapping("/updateProjectDetails/{projectId}")
	public ProjectDetails updateProjectDetails(@RequestBody ProjectDetails projectDetails,@PathVariable int projectId) {
		return projectDetailsService.updateProjectDetails(projectDetails,projectId);
	}
	
	@DeleteMapping("/deleteProjectDetails/projectId")
	public String deleteProjectDetails(@PathVariable int projectId){
		return projectDetailsService.deleteProjectDetails(projectId);
	}
	
}
