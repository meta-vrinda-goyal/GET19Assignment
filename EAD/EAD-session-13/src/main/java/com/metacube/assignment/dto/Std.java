package com.metacube.assignment.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Std {
	
	@NotNull(message = "{blankClass}")
	@Pattern(regexp = "^[1-9]|1[0-2]$", message = "{validClass}")
	private String std;

	public Std() {
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}
}
