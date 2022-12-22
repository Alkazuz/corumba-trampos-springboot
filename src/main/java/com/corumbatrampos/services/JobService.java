package com.corumbatrampos.services;

import org.springframework.stereotype.Service;

import com.corumbatrampos.repositories.CompanyRepository;
import com.corumbatrampos.repositories.JobRepository;

@Service
public class JobService {
	
	private final CompanyRepository companyRepository;
	private final JobRepository jobRepository;
	
	public JobService(CompanyRepository companyRepository, JobRepository jobRepository) {
		super();
		this.companyRepository = companyRepository;
		this.jobRepository = jobRepository;
	}

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public JobRepository getJobRepository() {
		return jobRepository;
	}
	
	
	
}
