package com.example.ManagementTool.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "issues_tbl")
public class Issues {
	@Id
	@GeneratedValue
	private int issueId;
	private String issueDescription;
	private Date issueDate;
	private String testingStatus;
	private int runningNumber;
	

}
