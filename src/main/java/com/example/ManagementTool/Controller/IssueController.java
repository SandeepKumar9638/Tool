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

import com.example.ManagementTool.Entity.Issues;
import com.example.ManagementTool.Service.IssuesService;

@RestController
public class IssueController {

	@Autowired
	IssuesService issuesService;

	@PostMapping("/createIssue")
	public Issues postIssues(@RequestBody Issues issues) {
		return issuesService.postIssues(issues);
	}

	@GetMapping("/getAllIssues")
	public List<Issues> getAllIssues() {
		return issuesService.getAllIssues();
	}

	@GetMapping("/getAllIssues/{issueId}")
	public Optional<Issues> getIssuesById(@PathVariable int issueId) {
		return issuesService.getIssuesById(issueId);
	}

	@PutMapping("/updateIssues/{issueId}")
	public Issues updateIssues(@RequestBody Issues issues,@PathVariable int issueId) {
		return issuesService.updateIssues(issues,issueId);
	}
	
	@DeleteMapping("/deleteIssues/issueId")
	public String deleteIssues(@PathVariable int issueId){
		return issuesService.deleteIssues(issueId);
	}

}