package com.metacube.assignment.EADSession9.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.EADSession9.dao.PassDao;
import com.metacube.assignment.EADSession9.model.pojo.Pass;
@Repository
public class PassDaoImpl implements PassDao {
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT_PASS = "insert into passDetails"
			+ "(regId,plan,price) values(?,?,?)";

	@Autowired
	public PassDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean addPass(Pass pass) {
		return jdbcTemplate.update(SQL_INSERT_PASS,pass.getRegId(),pass.getPricePlan(),pass.getPriceInINR()) > 0;
	}

}
