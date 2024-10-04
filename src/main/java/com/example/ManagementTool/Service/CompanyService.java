package com.example.ManagementTool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ManagementTool.Entity.Company;
import com.example.ManagementTool.Repository.ComapnyRepo;

@Service
public class CompanyService {

	@Autowired
	ComapnyRepo comapnyRepo;

	public Company postCompany(Company company) {
		return comapnyRepo.save(company);
	}

	public List<Company> getCompany() {
		return comapnyRepo.findAll();
	}

	public Optional<Company> getCompanyById(Integer companyId) {
		return comapnyRepo.findById(companyId);
	}

	public Company updateComapnyDetails(Company company, Integer companyId) {
		return comapnyRepo.save(company);
	}

	public String deleteComapnyDetails(Integer companyId) {
		Company i = comapnyRepo.findByCompanyId(companyId);
		if (i != null) {
			comapnyRepo.delete(i);
		}
		return "deleted";
	}

}
