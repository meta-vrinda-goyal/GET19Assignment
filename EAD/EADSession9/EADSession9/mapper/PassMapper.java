package com.metacube.assignment.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.EADSession9.model.pojo.Pass;
import com.metacube.assignment.EADSession9.model.pojo.Vehicle;

public class PassMapper implements RowMapper<Pass>{

	@Override
	public Pass mapRow(ResultSet result, int i) throws SQLException {
		Pass pass =  new Pass();
		pass.setRegId(result.getInt("regId"));
		pass.setPricePlan(result.getString("pricePlan"));
		pass.setPriceInINR(result.getInt("priceInINR"));
		return pass;
	}

}
