package com.example.ManagementTool.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;

import com.example.ManagementTool.Entity.EmployeeDetails;
import com.example.ManagementTool.Repository.EmployeeDetailsRepo;

@Service
public class EmployeeDetailsService {

	@Autowired
	EmployeeDetailsRepo managementToolRepo;

	@Value("${imageDirForDoctors}")
	private String imageDirForDoctors;

	@Value("${imageDirForFrontOffice}")
	private String imageDirForFrontOffice;

	@Value("${imageDirForNurses}")
	private String imageDirForNurses;

	@Value("${imageDirForOthers}")
	private String imageDirForOthers;

	public EmployeeDetails postingDetailsofEmployee(EmployeeDetails managementTool) {
		// managementTool.setGeneratedDate(LocalDateTime.now());

		return managementToolRepo.save(managementTool);

	}

	public List<EmployeeDetails> getAllEmployeeDetails() {
		return managementToolRepo.findAll();
	}

	@ExceptionHandler
	public byte[] getEmployeeImageByName(String employeeImage) throws IOException {
		StringBuilder name = new StringBuilder();
		name.append(imageDirForDoctors);
		name.append(employeeImage);
		name.append(".jfif");
		System.out.println(name);

		Path imagePath = Paths.get(name.toString());

		byte[] data = Files.readAllBytes(imagePath);

		return data;

	}

	public EmployeeDetails postingEmployeeImage(MultipartFile employeeImage) throws IllegalStateException, IOException {

		EmployeeDetails managementTool = new EmployeeDetails();
		String fileName = employeeImage.getOriginalFilename();

		if (fileName.startsWith("d") || fileName.startsWith("D")) {
			String path = imageDirForDoctors + fileName;
			employeeImage.transferTo(new File(path));
			managementTool.setImagePath(path);
		} else if ((fileName.startsWith("n") || fileName.startsWith("N"))) {
			String path2 = imageDirForNurses + fileName;
			employeeImage.transferTo(new File(path2));
			managementTool.setImagePath(path2);
		} else if ((fileName.startsWith("f") || fileName.startsWith("F"))) {
			String path3 = imageDirForFrontOffice + fileName;
			employeeImage.transferTo(new File(path3));
			managementTool.setImagePath(path3);
		} else {
			String path1 = imageDirForOthers + fileName;
			System.out.println(path1);
			employeeImage.transferTo(new File(path1));
			managementTool.setImagePath(path1);
		}

		// ManagementTool name = new ManagementTool();
		managementTool.setEmployeeImage(fileName);
		return managementToolRepo.save(managementTool);
	}

	public EmployeeDetails updateEmployeeDetails(EmployeeDetails managementTool, int id) {

		return managementToolRepo.save(managementTool);
	}

}
