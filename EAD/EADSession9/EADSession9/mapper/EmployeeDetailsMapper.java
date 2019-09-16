package com.metacube.assignment.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.EADSession9.dto.EmployeeDetails;

public class EmployeeDetailsMapper implements RowMapper<EmployeeDetails> {

	@Override
	public EmployeeDetails mapRow(ResultSet result, int i) throws SQLException {
		EmployeeDetails emp = new EmployeeDetails();
		emp.setRegId(result.getInt(1));
		emp.setFirstName(result.getString(2));
		emp.setLastName(result.getString(3));
		emp.setGender(result.getString(4));
		emp.setEmail(result.getString(5));
		emp.setContactNumber(result.getString(6));
		emp.setOrganization(result.getString(7));
		emp.setVehicleName(result.getString(8));
		emp.setVehicleType(result.getString(9));
		emp.setVehicleNumber(result.getString(10));
		emp.setIdentification(result.getString(11));
		emp.setPlan(result.getString(12));
		emp.setPrice(result.getInt(13));
		return emp;
	}

}
