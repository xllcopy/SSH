package com.xll.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xll.dao.UserDao;
import com.xll.pojo.User;
@Repository
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao{

	@Resource
	private SessionFactory sessionFactory;
	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User login(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User where loginName = ? and password = ?";
		User user = (User)session.createQuery(hql).setString(0, username).setString(1, password).uniqueResult();
		return user;
	}

}
