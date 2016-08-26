package com.xll.dao;

import com.xll.pojo.User;

public interface UserDao extends BasicDao<User>{
	public User login(String username , String password);
}
