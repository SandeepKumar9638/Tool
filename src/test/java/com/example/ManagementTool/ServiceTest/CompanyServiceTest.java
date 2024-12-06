package com.example.ManagementTool.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ManagementTool.Entity.Company;
import com.example.ManagementTool.Repository.ComapnyRepo;
import com.example.ManagementTool.Service.CompanyService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

	@Mock
	ComapnyRepo comapnyRepo;// = new ComapnyRepo();

	@InjectMocks
	CompanyService companyService;// = new CompanyService();
	
	@Mock
	Company company;

	@BeforeAll
	public static void init() {
		System.out.println("before");
	}

	@Test
	void postCompanyTest() {

		company.setCompanyId(2);

		when(comapnyRepo.save(company)).thenReturn(company);

		Company saveCompany = companyService.postCompany(company);

		assertEquals(company.getCompanyId(), saveCompany.getCompanyId());
		System.out.println("checking");
	}

	@Test
	public void getCompanyTest() {
		List<Company> asList = Arrays.asList(company);
		when(comapnyRepo.findAll()).thenReturn(asList);
		List<Company> company2 = companyService.getCompany();
		assertEquals(company.getComapnyName(), company2.get(0).getComapnyName());
	}

	@AfterAll
	public static void afterall() {
		System.out.println("cleanup");
	}
}
