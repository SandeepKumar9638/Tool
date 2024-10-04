package com.example.ManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManagementTool.Entity.Issues;

@Repository
public interface IssuesRepo extends JpaRepository<Issues, Integer> {

	Issues findByissueId(int issueId);

}
