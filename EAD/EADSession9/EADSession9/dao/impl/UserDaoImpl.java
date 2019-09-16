package com.metacube.assignment.EADSession9.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.EADSession9.dao.UserDao;
import com.metacube.assignment.EADSession9.dto.EmployeeDetails;
import com.metacube.assignment.EADSession9.dto.Friend;
import com.metacube.assignment.EADSession9.dto.FriendProfile;
import com.metacube.assignment.EADSession9.mapper.EmployeeDetailsMapper;
import com.metacube.assignment.EADSession9.mapper.FriendMapper;


import com.metacube.assignment.EADSession9.mapper.FriendProfileMapper;
import com.metacube.assignment.EADSession9.model.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {

	

	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_USER = "insert into employee_details "
			+ "(firstName,lastName,gender,email,password,contact,organization) values(?,?,?,?,?,?,?) ";
	private final String SQL_GET_USER_REG_ID = "SELECT regId FROM employee_details WHERE EMAIL = ? ";
	private final String SQL_USER_EMAIL = "SELECT regId FROM employee_details WHERE EMAIL = ? ";
	private final String SQL_USER_PASSWORD = "SELECT PASSWORD FROM employee_details WHERE EMAIL = ? ";
	private final String SQL_GET_EMP_DETAILS ="SELECT e.regId ,firstName,lastName,gender,email, "
			+ "contact,organization,vehicle_name,vehicle_type,vehicle_number "
			+ ",Identification,plan,price from "
			+ "employee_details e , vehicle v , passDetails p where e.regId = ? and e.regId = v.regId and e.regId = p.regId ";
	private final String SQL_GET_FRIEND_LIST = "select regId , firstName ,lastName from employee_details where regId not in (?) and  organization = ? ";
	private final String SQL_GET_FRIEND_PROFILE = "SELECT e.regId,firstName,lastName,gender,email,contact,vehicle_name,vehicle_number, "
			+ "vehicle_type FROM employee_details e , vehicle v where e.regId = ? and e.regId = v.regId " ;
	private final String SQL_UPDATE_PROFILE = "UPDATE employee_details e, vehicle v SET firstName=?,lastName=?,gender=?,contact=?,vehicle_name=?,vehicle_number=?,identification=? "
			+ "where e.regId=? and e.regId=v.regId ";
	private static final String SQL_USER_ADDED_VEHICLE = "SELECT vehicle_name FROM VEHICLE WHERE regId = ? ";
	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean add(User user) {
		return jdbcTemplate.update(SQL_INSERT_USER, user.getFirstName(),
				user.getLastName(), user.getGender(), user.getEmail(),
				user.getPassword(), user.getContactNumber(),
				user.getOrganization()) > 0;
	}

	@Override
	public int getUserRegId(String email) {
		return jdbcTemplate.queryForObject(SQL_GET_USER_REG_ID,
				new Object[] { email }, int.class);
	}

	@Override
	public boolean userExists(String email) {
		try {
			int id = jdbcTemplate.queryForObject(SQL_USER_EMAIL,
					new Object[] { email }, int.class);
			return true;
		} catch (DataAccessException e) {
			return false;
		}
	}

	@Override
	public String getPassword(String email) {
		try {
			String pass = jdbcTemplate.queryForObject(SQL_USER_PASSWORD,
					new Object[] { email }, String.class);
			return pass;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public EmployeeDetails getEmpDetails(Integer regId){
		
		try {
			return jdbcTemplate.queryForObject(SQL_GET_EMP_DETAILS,
					new Object[] { regId },new EmployeeDetailsMapper());
		} 
		catch (EmptyResultDataAccessException e) {
			
			//e.printStackTrace();
			return new EmployeeDetails();
		}
	}

	@Override
	public List<Friend> getFriendList(Integer empRegId,
			String empOrganization) {
		
		return jdbcTemplate.query(SQL_GET_FRIEND_LIST,new Object[] { empRegId,empOrganization},new FriendMapper());
	}

	@Override
	public FriendProfile getFriendProfile(Integer regId) {
		
		return jdbcTemplate.queryForObject(SQL_GET_FRIEND_PROFILE,new Object[] {regId},new FriendProfileMapper());
	}

	@Override
	public boolean updateDetail(EmployeeDetails emp) {
		//try {
		    //System.out.println(emp.getContactNumber());
			jdbcTemplate.update(SQL_UPDATE_PROFILE,emp.getFirstName(),emp.getLastName(),emp.getGender(),emp.getContactNumber(),emp.getVehicleName(),emp.getVehicleNumber(),emp.getIdentification(),emp.getRegId());
			return true;
		//} 
		//catch (DataAccessException e) {
		//	return false;
		//}
		
	}

	@Override
	public boolean userAddedVehicle(int userRegId) {
		try {
			String vehicleName = jdbcTemplate.queryForObject(SQL_USER_ADDED_VEHICLE,
					new Object[] { userRegId }, String.class);
			return true;
		} catch (DataAccessException e) {
			return false;
		}
	}

}
