package com.example.ManagementTool.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="comapny_tbl")
public class Company {

	@Id
	@GeneratedValue
	private int companyId;
	private String comapnyName;
	private String companyAddress;
	private long mobileNo;
	
/*	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Director> director = new HashSet<>();*/
	
}
