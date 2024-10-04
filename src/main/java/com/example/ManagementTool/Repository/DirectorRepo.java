package com.example.ManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ManagementTool.Entity.Director;

public interface DirectorRepo extends JpaRepository<Director, Integer> {

	Director findBydirectorId(Integer directorId);

	@Query(value="SELECT COUNT(*) FROM Director d WHERE d.company_id = :companyId", nativeQuery=true)
	Long countByCompanyId(Long companyId);

}
