package com.corumbatrampos.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.corumbatrampos.exceptions.repositories.ResourceNotFoundException;
import com.corumbatrampos.model.Job;
import com.corumbatrampos.repositories.JobRepository;

@Service
public class JobServices {
	
	private static final String NOT_FOUND_FORMAT = "No records found for id %d!";
	
	private Logger logger = Logger.getLogger(JobServices.class.getName());
	
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	JobRepository repository;
	
	
	public List<Job> findAll() {

		logger.info("Finding all jobs!");

		return repository.findAll();
	}
	
	public Job create(Job job) {

		logger.info("Creating one job!");
		
		return repository.save(job);
	}
	
	public Job update(Job job) throws ResourceNotFoundException {
		
		logger.info("Updating one job!");
		
		Job entity = repository.findById(job.getId())
			.orElseThrow(() -> new ResourceNotFoundException(job.getId(), String.format(NOT_FOUND_FORMAT, job.getId())));

		entity.setName(job.getName());
		entity.setDescription(job.getDescription());
		entity.setSalary(job.getSalary());
		entity.setJobs(job.getJobs());
		
		return repository.save(job);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
		
		logger.info("Deleting one job!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id, String.format(NOT_FOUND_FORMAT, id)));
		repository.delete(entity);
	}

	public Job findById(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id, String.format(NOT_FOUND_FORMAT, id)));
	}
	
}
