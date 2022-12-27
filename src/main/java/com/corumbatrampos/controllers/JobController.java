package com.corumbatrampos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.corumbatrampos.vo.v1.JobVO;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobServices service;
	
	@GetMapping(value = "/all",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JobVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/find/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public JobVO findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return service.findById(id);
	}
	
	@PostMapping(value = "/new",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public JobVO create(@RequestBody JobVO job) {
		return service.create(job);
	}
	
	@DeleteMapping(value = "/delete/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("JOB_NOT_FOUND", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
}
