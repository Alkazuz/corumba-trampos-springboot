package com.corumbatrampos.exceptions.repositories;

import java.io.Serializable;


public class ResourceNotFoundException extends Exception implements Serializable {

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
