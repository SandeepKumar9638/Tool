package com.example.ManagementTool.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

//@Data
@Entity
@NoArgsConstructor

@Table(name = "employee_details_tbl")
public class EmployeeDetails extends Dates {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String role;
	private String department;
	private double salary;
	private String address;
	private String employeeImage;
//	private LocalDateTime generatedDate;
//	private LocalDateTime updatedDate;
	private String imagePath;
	private String managerName;
	private String projectWorking;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if(salary==300) {
			this.salary = salary;
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmployeeImage() {
		return employeeImage;
	}
	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getProjectWorking() {
		return projectWorking;
	}
	public void setProjectWorking(String projectWorking) {
		
		this.projectWorking = projectWorking;
	}
	
	

	/*enum methods {

		Post, Put
	}

	@PrePersist
	protected void onCreate() {
		if (methods.Post != null) {
			generatedDate = LocalDateTime.now();
		} else {
			updatedDate = LocalDateTime.now();
		}
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = LocalDateTime.now();
	}*/
}
