/**
 * Esta classe representa um empprego cadastrado no sistema.
 * Ela possui nome, descrição, salario e referência da empresa.
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class Job implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	private String name;
	@Column
	private String description;
	@Column
	private int salary;
	@Column
	private int jobs;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	@JsonBackReference
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "sector_id")
	@JsonBackReference
	private Sector sector;

	/**
	 * Retorna a identidade unica do emprego
	 * @return A identidade unica do emprego.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Retorna o nome do emprego
	 * @return O o nome do emprego
	 */
	public String getName() {
		return name;
	}

	/**
	 * Altera o nome da vaga
	 * @param name Novo nome da vaga
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna o nome do emprego
	 * @return O nome do emprego
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Altera a descrição da vaga
	 * @param description Nova descrição da vaga
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retorna o nome do emprego
	 * @return O o nome do emprego
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Altera o salário da vaga
	 * @param salary Novo salário da vaga.
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * Retorna a empresa responsável pega vaga
	 * @return A empresa responsável pega vaga
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * Retorna a quantidade disponiveis de vagas
	 * @return A quantidade disponiveis de vagas
	 */
	public int getJobs() {
		return jobs;
	}

	/**
	 * Altera a quantidade disponiveis de vagas
	 * @param jobs Nova quantidade disponiveis de vagas.
	 */
	public void setJobs(int jobs) {
		this.jobs = jobs;
	}

}
