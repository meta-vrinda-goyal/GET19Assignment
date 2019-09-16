package com.metacube.assignment.EADSession9.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment.EADSession9.dao.PassDao;
import com.metacube.assignment.EADSession9.dao.UserDao;
import com.metacube.assignment.EADSession9.model.pojo.Pass;
import com.metacube.assignment.EADSession9.service.PassService;
@Service
public class PassServiceImpl implements PassService {
	@Autowired
	private PassDao passDao;
	
	@Override
	public boolean addPass(Pass pass) {
		return passDao.addPass(pass);
	}

}
