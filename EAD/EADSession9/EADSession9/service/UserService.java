package com.metacube.assignment.EADSession9.service;

import java.util.List;

import com.metacube.assignment.EADSession9.dto.EmployeeDetails;


import com.metacube.assignment.EADSession9.dto.Friend;
import com.metacube.assignment.EADSession9.dto.FriendProfile;
import com.metacube.assignment.EADSession9.model.pojo.User;


public interface UserService {
	
	public abstract boolean addUser(User user);
	public abstract int getUserRegId(String email);
	public abstract boolean userExists(String email);
	public abstract String getPassword(String email);
	public abstract EmployeeDetails getEmpDetails(Integer regId);
	public abstract List<Friend> getFriendList(Integer empRegId,
			String empOrganization);
	public abstract FriendProfile getFriendProfile(Integer regId);
	public abstract boolean updateDetail(EmployeeDetails emp);
	public abstract boolean userAddedVehicle(int userRegId);
	
	

}
