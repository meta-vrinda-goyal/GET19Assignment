package com.metacube.assignment.EADSession9.model.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@Size(min = 2 , max = 20, message = "{firstName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String firstName;
	
	@Size(max = 20,message = "{lastName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String lastName;
	
	@NotBlank(message = "{blankGender}")
	private String gender;
	
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	@Pattern(regexp = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}",message="{password}")
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@Size( min = 2 , max = 20, message="{blankContact}")
	private String contactNumber;
	
	@NotNull(message = "{blankOrganization}")
	private String organization;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}


}
