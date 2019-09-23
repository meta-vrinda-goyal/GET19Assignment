package com.servlets;

public class Queries {
	public static String queryForAddStudent() {
		return "INSERT INTO STUDENT_DETAIL VALUES(?, ?, ?, ?, ?, ?)";
	}

	public static String queryForShowStudents() {
		return "SELECT * FROM STUDENT_DETAIL";
	}

	public static String queryForUpdateStudent() {
		return "UPDATE STUDENT_DETAIL SET first_name = ?, last_name = ? ,father_name = ?, class=?, age = ? where email = ?";
	}

	public static String queryForSearchByName() {
		return "SELECT * FROM STUDENT_DETAIL WHERE first_name = ? AND last_name = ? ";
	}

	public static String queryForSearchByClass() {
		return "SELECT * FROM STUDENT_DETAIL WHERE class=? ";
	}
}