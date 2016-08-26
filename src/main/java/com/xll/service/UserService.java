package com.xll.service;

import com.xll.pojo.User;

/**
 *@author xialonglei
 *@since 2016/8/21 
 */
public interface UserService extends BasicService<User>{
	public User login(String username , String password);
}
