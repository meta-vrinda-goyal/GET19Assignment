package com.servlets;

public class Queries {

	public static String queryForAddEmployee() {

		return "insert into employee_details (firstName,lastName,gender,email,password,contact,organization) values(?,?,?,?,?,?,?) ";
	}

	public static String queryForGetEmpRegID() {

		return "SELECT MAX(regId) FROM employee_details";
	}

	public static String queryForLoginEmployee() {

		return "select password from employee_details where regId = ?";
	}

	public static String queryForAddVehicle() {

		return "insert into vehicle (regId,vehicle_name,vehicle_type,vehicle_number,Identification) values(?,?,?,?,?)";
	}

	public static String queryForAddPassDetail() {

		return "insert into passDetails (regId,plan,price) values (?,?,?)";
	}

	public static String queryForShowDetail() {

		return "select e.regId,firstName,lastName,gender,email,contact,organization,vehicle_name,vehicle_type,vehicle_number,Identification,plan,price from "
				+ "employee_details e , vehicle v , passDetails p where e.regId = ? and e.regId = v.regId and e.regId = p.regId ";
	}

	public static String queryForShowFriends() {
		
		return "select regId , firstName ,lastName from employee_details where regId not in (?) and  organization = ? ";
	}

	public static String queryForShowFriendProfile() {
		
		return "select regId,firstName,lastName,gender,email,contact,organization from "
				+ "employee_details where regId =?  ";
	}

}
