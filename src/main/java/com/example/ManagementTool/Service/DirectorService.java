package com.example.ManagementTool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ManagementTool.Controller.CompanyDto;
import com.example.ManagementTool.Entity.Company;
import com.example.ManagementTool.Entity.Director;
import com.example.ManagementTool.Repository.ComapnyRepo;
import com.example.ManagementTool.Repository.DirectorRepo;

@Service
public class DirectorService {

	@Autowired
	DirectorRepo directorRepo;

	@Autowired
	ComapnyRepo comapnyRepo;

	public Director postDetails(Director directorEntity) {
		return directorRepo.save(directorEntity);
	}

	public List<Director> getDirector() {
		return directorRepo.findAll();
	}

	public Optional<Director> getDirectorById(Integer directorId) {
		return directorRepo.findById(directorId);
	}

	public Director updateDirectorDetails(Director director, int directorId) {
		return directorRepo.save(director);
	}

	public String deleteDirecorDetails(Integer directorId) {
		Director i = directorRepo.findBydirectorId(directorId);
		if (i != null) {
			directorRepo.delete(i);
		}
		return "deleted";
	}

	public Director linkCompanyToDirector(int directorId, int comapnyId) {
		Company name = new Company();
		Director directorIds = directorRepo.findBydirectorId(directorId);
		Company comapnyIds = comapnyRepo.findByCompanyId(comapnyId);
		if (directorIds != null && comapnyIds != null) {

			directorIds.setCompany(comapnyIds);
			return directorRepo.save(directorIds);
		} else {
			throw new RuntimeException("comapny || director details not found");
		}

	}

	public Long countDirectorsByCompanyId(Long companyId) {
		return directorRepo.countByCompanyId(companyId);
	}

}
