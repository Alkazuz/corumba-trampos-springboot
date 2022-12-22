package com.corumbatrampos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
