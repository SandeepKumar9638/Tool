package com.example.ManagementTool.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
//@Entity
@MappedSuperclass
public class Dates {

	
	private LocalDateTime generatedDate;
	private LocalDateTime updatedDate;
	
	enum method{
		POST,PUT
	}
	
	@PrePersist
	protected void createDate() {
		if(method.POST != null) {
			generatedDate=LocalDateTime.now();
		}
		else {
			updatedDate=LocalDateTime.now();
		}
	}
	
	@PreUpdate
	protected void updateDate() {
		updatedDate=LocalDateTime.now();
	}
}
