package com.metacube.assignment.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment.EADSession9.model.pojo.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle>{

	@Override
	public Vehicle mapRow(ResultSet result, int i) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setRegId(result.getInt("regId"));
		vehicle.setVehicleName(result.getString("vehicleName"));
		vehicle.setVehicleNumber(result.getString("vehicleNumber"));
		vehicle.setVehicleType(result.getString("vehicleType"));
		vehicle.setIdentification(result.getString("identification"));
		return null;
	}

}
