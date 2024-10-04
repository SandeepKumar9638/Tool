package com.example.ManagementTool.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@Data
@Entity
@Table(name = "project_details_tbl")
public class ProjectDetails {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	private String projectManager;
	private Date startDate;
	private String client;
	private String projectCode;

	/*@OneToMany
	private Issues issues;

	public Issues getIssues() {
		return issues;
	}

	public void setIssues(Issues issues) {
		this.issues = issues;
	}*/

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public int getProjectId() {
		return projectId;
	}

	public ProjectDetails setProjectId(int projectId) {
		this.projectId = projectId;
		return this;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
