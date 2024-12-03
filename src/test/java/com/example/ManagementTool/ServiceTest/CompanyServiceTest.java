package com.example.ManagementTool.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ManagementTool.Entity.Company;
import com.example.ManagementTool.Repository.ComapnyRepo;
import com.example.ManagementTool.Service.CompanyService;


@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

	@Mock
	ComapnyRepo comapnyRepo;// = new ComapnyRepo();

	@InjectMocks
	CompanyService companyService;// = new CompanyService();

	@Test
	void postCompanyTest() {
		Company company = new Company();
		company.setCompanyId(2);

		Mockito.when(comapnyRepo.save(company)).thenReturn(company);
		Company saveCompany = companyService.postCompany(company);

		assertEquals(company.getCompanyId(), saveCompany.getCompanyId());
		System.out.println("checking");
	}
}
