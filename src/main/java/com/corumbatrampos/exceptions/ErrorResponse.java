package com.corumbatrampos.exceptions;

import java.util.Date;

public class ErrorResponse {

	private Date date;
	private String errorCode;
	private String errorMessage;
	private String details;

	public ErrorResponse(String errorCode, String errorMessage) {
		this.date = new Date();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(String errorCode, String errorMessage, String details) {
		this.date = new Date();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getDetails() {
		return details;
	}

	public Date getDate() {
		return date;
	}
	
	
}
