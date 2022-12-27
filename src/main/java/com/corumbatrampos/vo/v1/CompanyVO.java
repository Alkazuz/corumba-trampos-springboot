/**
 * Esta classe representa uma empresa cadastrado no sistema como Value Object.
 * Ela possui nome, descrição, salario e referência da empresa.
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.vo.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.corumbatrampos.model.Job;
public class CompanyVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String logo;
	private String cnpj;
	private List<Job> job = new ArrayList<>();

	public CompanyVO() {}
	
	public CompanyVO(Long id, String name, String logo, String cnpj, List<Job> job) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.cnpj = cnpj;
		this.job = job;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}
	
	

}
