package com.xll.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.dao.UserDao;
import com.xll.pojo.User;
import com.xll.service.UserService;
@Service
public class UserServiceImpl extends BasicServiceImpl<User> implements UserService{

	@Resource 
	private UserDao userDaoImpl;
	@Override
	public User login(String username, String password) {
		return userDaoImpl.login(username, password);
	}

}
