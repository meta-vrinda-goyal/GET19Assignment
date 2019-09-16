package com.metacube.assignment.EADSession9.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.metacube.assignment.EADSession9.dao.VehicleDao;
import com.metacube.assignment.EADSession9.model.pojo.Vehicle;
import com.metacube.assignment.EADSession9.service.VehicleService;
@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		
		return vehicleDao.addVehicle(vehicle);
	}

}
