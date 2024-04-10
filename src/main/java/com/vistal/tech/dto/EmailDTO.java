package com.vistal.tech.dto;

import java.util.List;

public class EmailDTO {

	private List<String> toEmails;
	private String type;

	public List<String> getToEmails() {
		return toEmails;
	}

	public void setToEmails(List<String> toEmails) {
		this.toEmails = toEmails;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EmailDTO [toEmails=" + toEmails + ", type=" + type + "]";
	}

}
