package com.example.ManagementTool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.ManagementTool.Entity.Issues;
import com.example.ManagementTool.Entity.ProjectDetails;
import com.example.ManagementTool.Repository.IssuesRepo;

import jakarta.transaction.Transactional;

@Service
public class IssuesService {

	@Autowired
	IssuesRepo issuesRepo;

	@Value("${issueId}")
	private int issueId;

	@Transactional
	public Issues postIssues(Issues issues) {
		ProjectDetails name = new ProjectDetails();
		String code = name.getProjectCode();
		String h = code + String.valueOf(issueId);
		System.out.println(h);
		System.out.println("h value");
		return issuesRepo.save(issues);
	}

	public List<Issues> getAllIssues() {
		return issuesRepo.findAll();
	}

	public Optional<Issues> getIssuesById(int issueId) {
		return issuesRepo.findById(issueId);
	}

	public Issues updateIssues(Issues issues, int issueId) {
		return issuesRepo.save(issues);

	}

	public String deleteIssues(int issueId) {
		Issues issues = issuesRepo.findByissueId(issueId);
		if (issues != null) {
			issuesRepo.delete(issues);
		}
		return "deleted the issue";
	}

}
