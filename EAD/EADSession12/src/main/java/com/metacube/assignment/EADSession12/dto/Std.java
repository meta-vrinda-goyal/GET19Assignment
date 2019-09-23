package com.metacube.assignment.EADSession12.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Std {
	
	@NotNull(message = "{blankStd}")
	@Min(1)
	@Max(12)
	private int std;

	public Std() {
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}
}
