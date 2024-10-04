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

import com.example.ManagementTool.Entity.Director;
import com.example.ManagementTool.Service.DirectorService;

@RestController
public class DirectorController {

	@Autowired
	DirectorService directorService;

	@PostMapping("/postDirector")
	public Director postDetails(@RequestBody Director directorEntity) {
		return directorService.postDetails(directorEntity);
	}

	@GetMapping("/getDirector")
	public List<Director> getDirector() {
		return directorService.getDirector();
	}
	
	@GetMapping("/getDirector/{directorId}")
	public Optional<Director> getDirectorById(@PathVariable Integer directorId) {
		return directorService.getDirectorById(directorId);
	}
	
	@PutMapping("/updateDetails/{directorId}")
	public Director updateDirectorDetails(@RequestBody Director director,@PathVariable Integer directorId ) {
		return directorService.updateDirectorDetails(director,directorId);
	}
	
	@DeleteMapping("/deleteDirector/{directorId}")
	public String deleteDirecorDetails(@PathVariable Integer directorId) {
		return directorService.deleteDirecorDetails(directorId);
	}
	
	@PostMapping("/{directorId}/linkComapny/{comapnyId}")
	public Director linkCompanyToDirector(@PathVariable int directorId,@PathVariable int comapnyId) {
		return directorService.linkCompanyToDirector(directorId,comapnyId);
	}
	
	@GetMapping("/countByCompany/{companyId}")
    public Long countDirectorsByCompanyId(@PathVariable Long companyId) {
        return directorService.countDirectorsByCompanyId(companyId);
    }

}
