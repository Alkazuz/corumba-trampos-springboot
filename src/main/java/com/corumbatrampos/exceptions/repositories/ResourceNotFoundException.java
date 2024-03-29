package com.corumbatrampos.exceptions.repositories;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

    public ResourceNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

}
