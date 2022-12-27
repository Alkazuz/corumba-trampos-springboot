/**
 * Esta classe representa um empprego cadastrado no sistema como Value Object.
 * Ela possui nome, descrição, salario e referência da empresa.
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.vo.v1;

import java.io.Serializable;

import com.corumbatrampos.model.Company;
import com.corumbatrampos.model.Sector;
public class JobVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private int salary;
	private int jobs;
	private Company company;
	private Sector sector;

	/**
	 * Retorna a identidade unica do emprego
	 * @return A identidade unica do emprego.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public void setCompany(Company company) {
		this.company = company;
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
