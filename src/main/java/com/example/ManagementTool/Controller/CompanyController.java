package com.example.ManagementTool.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManagementTool.Entity.Company;
import com.example.ManagementTool.Service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("/postCompany")
	public Company postCompany(@RequestBody Company company) {
		return companyService.postCompany(company);
	}

	@GetMapping("/getCompany")
	public List<Company> getCompany() {
		return companyService.getCompany();
	}

	@GetMapping("/getCompany/{companyId}")
	public Optional<Company> getCompanyById(@PathVariable Integer companyId) {
		return companyService.getCompanyById(companyId);
	}

	@PutMapping("/updateComapnyDetails/{companyId}")
	public Company updateComapnyDetails(@RequestBody Company company, @PathVariable Integer companyId) {
		return companyService.updateComapnyDetails(company, companyId);
	}

	@DeleteMapping("/deleteComapnyDetails/{companyId}")
	public String deleteComapnyDetails(@PathVariable Integer companyId) {
		return companyService.deleteComapnyDetails(companyId);
	}
}
