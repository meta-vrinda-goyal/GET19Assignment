package com.metacube.assignment.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.EADSession9.model.pojo.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet result, int i) throws SQLException {
		User user = new User();
		user.setFirstName(result.getString("firstName"));
		user.setLastName(result.getString("lastName"));
		user.setGender(result.getString("gender"));
		user.setEmail(result.getString("email"));
		user.setPassword(result.getString("password"));
		user.setContactNumber(result.getString("contactNumber"));
		user.setOrganization(result.getString("organization"));
		return user;
	}

}
