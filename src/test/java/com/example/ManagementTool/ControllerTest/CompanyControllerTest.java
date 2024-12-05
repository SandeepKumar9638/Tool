package com.example.ManagementTool.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ManagementTool.Controller.CompanyController;
import com.example.ManagementTool.Entity.Company;
import com.example.ManagementTool.Service.CompanyService;

@ExtendWith(MockitoExtension.class)
public class CompanyControllerTest {

	@Mock
	CompanyService comService = new CompanyService();

	@InjectMocks
	CompanyController company = new CompanyController();

	Company com = new Company();
	
	@Test
	void postCompanyTest() {
		
		Company postCompany = comService.postCompany(com);
	//	assertEquals(com.getMobileNo(), postCompany.getMobileNo());
	}
	
	void getCompanyTest() {
		
	}

}
