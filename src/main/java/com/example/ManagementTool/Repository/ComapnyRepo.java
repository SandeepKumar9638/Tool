package com.example.ManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManagementTool.Entity.Company;

public interface ComapnyRepo extends JpaRepository<Company, Integer> {

	Company findByCompanyId(Integer companyId);

}
