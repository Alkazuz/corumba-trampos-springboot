package com.corumbatrampos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.corumbatrampos.exceptions.ErrorResponse;
import com.corumbatrampos.exceptions.repositories.ResourceNotFoundException;
import com.corumbatrampos.model.Job;
import com.corumbatrampos.services.JobServices;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobServices service;
	
	@GetMapping(value = "/all",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Job> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/find/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Job findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return service.findById(id);
	}
	
	@PostMapping(value = "/new",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Job create(@RequestBody Job job) {
		return service.create(job);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("JOB_NOT_FOUND", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
}
