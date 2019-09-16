package com.metacube.assignment.EADSession9.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.EADSession9.dao.VehicleDao;
import com.metacube.assignment.EADSession9.model.pojo.Vehicle;
@Repository
public class VehicleDaoImpl implements VehicleDao {
	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT_VEHICLE = "insert into vehicle"
			+ "(regId,vehicle_name,vehicle_type,vehicle_number,Identification) values(?,?,?,?,?)";

	@Autowired
	public VehicleDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {

		return jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicle.getRegId(),
				vehicle.getVehicleName(), vehicle.getVehicleType(),
				vehicle.getVehicleNumber(), vehicle.getIdentification()) > 0;
	}

}
