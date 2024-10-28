package com.example.ManagementTool.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ManagementTool.Entity.EmployeeDetails;
import com.example.ManagementTool.Service.EmployeeDetailsService;

@RestController
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetailsService managementToolService;

	@PostMapping("/postDetails")
	public EmployeeDetails postingDetailsofEmployee(@RequestPart EmployeeDetails managementTool) {

		return managementToolService.postingDetailsofEmployee(managementTool);

	}

	@PostMapping("/postEmployeeImage")
	public EmployeeDetails postingEmployeeImage(@RequestPart MultipartFile employeeImage)
			throws IllegalStateException, IOException {

		return managementToolService.postingEmployeeImage(employeeImage);

	}

	@GetMapping("/getEmployeeDetails")
	public List<EmployeeDetails> getAllEmployeeDetails() {
		EmployeeDetails emp = new EmployeeDetails();
		emp.setSalary(0);
		return managementToolService.getAllEmployeeDetails();

	}

	@GetMapping("/getEmployeeDetails/{employeeImage}")
	public ResponseEntity<?> getEmployeeImageByName(@PathVariable String employeeImage) {
		byte[] hi = managementToolService.getEmployeeImageByName(employeeImage);
		// return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(hi);
		return ResponseEntity.ok().body(hi);
	}

	@PutMapping("/updateEmployeeDetails/{id}")
	public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails managementTool, @PathVariable int id) {
		return managementToolService.updateEmployeeDetails(managementTool, id);

	}

}
