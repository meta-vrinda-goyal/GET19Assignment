package com.metacube.assignment.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.EADSession9.dto.Friend;


public class FriendMapper implements RowMapper<Friend> {

	@Override
	public Friend mapRow(ResultSet rs, int rowNum) throws SQLException {
		Friend friend = new Friend();
		friend.setRegId(rs.getInt(1));
		friend.setFirstName(rs.getString(2));
		friend.setLastName(rs.getString(3));
		return friend;
	}

}
