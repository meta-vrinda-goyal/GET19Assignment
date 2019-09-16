package com.metacube.assignment.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.EADSession9.dto.FriendProfile;

public class FriendProfileMapper implements RowMapper<FriendProfile>{

	@Override
	public FriendProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
		FriendProfile friendProfile = new FriendProfile();
		friendProfile.setRegId(rs.getInt(1));
		friendProfile.setFirstName(rs.getString(2));
		friendProfile.setLastName(rs.getString(3));
		friendProfile.setGender(rs.getString(4));
		friendProfile.setEmail(rs.getString(5));
		friendProfile.setContact(rs.getString(6));
		friendProfile.setVehchileName(rs.getString(7));
		friendProfile.setVehchileNumber(rs.getString(8));
		friendProfile.setVehchileType(rs.getString(9));
		return friendProfile;
		
	
	}

}
