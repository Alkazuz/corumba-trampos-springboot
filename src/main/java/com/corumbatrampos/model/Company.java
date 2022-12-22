/**
 * Esta classe representa uma empresa cadastrada no sistema.
 * Ela possui nome, lista de empregos e cnpj.
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@Column
	private String logo;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@OneToMany
	@JsonBackReference
	private List<Job> job = new ArrayList<>();

	/**
	 * Retorna a identidade unica da empresa
	 * @return A identidade unica da empresa.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Retorna o nome da empresa
	 * @return O nome da empresa
	 */
	public String getName() {
		return name;
	}

	/**
	 * Altera o nome da empresa
	 * @param name Novo nome da empresa.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna a logo da empresa
	 * @return A logo da empresa.
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Altera a logo da empresa
	 * @param logo Nova url de logo da empresa.
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * Retorna o cnpj da empresa
	 * @return O cnpj da empresa.
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Altera o cnpj da empresa
	 * @param cnpj Novo cnpj da empresa.
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Retorna a lista de empregos da empresa
	 * @return A lista de empregos da empresa.
	 */
	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id, job, logo, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id) && Objects.equals(job, other.job)
				&& Objects.equals(logo, other.logo) && Objects.equals(name, other.name);
	}
	
}
