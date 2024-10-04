package com.example.ManagementTool.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "director_tbl")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int directorId;
	private String name;
	private int age;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

}
