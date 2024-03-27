package com.vistal.tech.exception;

import java.sql.Timestamp;
import java.util.List;

public class ErrorResponse {
	// General error message about nature of error
	private String message;
	// Specific errors in API request processing
	private List<String> details;
	private String uri;
	private Timestamp timestamp;

	public ErrorResponse(String message, List<String> details, String uri, Timestamp timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.uri = uri;
		this.timestamp = timestamp;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

}
