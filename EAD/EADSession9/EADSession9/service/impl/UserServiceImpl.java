package com.metacube.assignment.EADSession9.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment.EADSession9.dao.UserDao;
import com.metacube.assignment.EADSession9.dto.EmployeeDetails;
import com.metacube.assignment.EADSession9.dto.Friend;
import com.metacube.assignment.EADSession9.dto.FriendProfile;
import com.metacube.assignment.EADSession9.model.pojo.User;
import com.metacube.assignment.EADSession9.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(User user) {
		return userDao.add(user);
	}

	@Override
	public int getUserRegId(String email) {
		
		return userDao.getUserRegId(email);
	}

	@Override
	public boolean userExists(String email) {
		
		return userDao.userExists(email);
	}

	@Override
	public String getPassword(String email) {
		
		return userDao.getPassword(email);
	}

	@Override
	public EmployeeDetails getEmpDetails(Integer regId) {
		
		return userDao.getEmpDetails(regId);
	}

	@Override
	public List<Friend> getFriendList(Integer empRegId,
			String empOrganization) {
		return userDao.getFriendList(empRegId,empOrganization);
	}

	@Override
	public FriendProfile getFriendProfile(Integer regId) {
		return userDao.getFriendProfile(regId);
	}

	@Override
	public boolean updateDetail(EmployeeDetails emp) {
		
		return userDao.updateDetail(emp);
	}

	@Override
	public boolean userAddedVehicle(int userRegId) {
		
		return userDao.userAddedVehicle(userRegId);
	}

	
}
