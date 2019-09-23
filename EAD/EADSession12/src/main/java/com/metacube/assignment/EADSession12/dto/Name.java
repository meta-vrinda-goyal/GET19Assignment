package com.metacube.assignment.EADSession12.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Name {
	
	@Size(min = 2, max = 20, message = "{firstName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
