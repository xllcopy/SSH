package com.xll.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xll.dao.BasicDao;

/**
 * @author xialonglei
 * @since 2016/6/10
 */
@Lazy(true)
@Transactional
@Repository("basicDao")
public class BasicDaoImpl<T> implements BasicDao<T> {
	@Resource
	protected SessionFactory sessionFactory;
	/** clazz中存储了当前操作的类型，即泛型T */
	private Class<?> clazz;

	public BasicDaoImpl(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void save(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void update(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from " + clazz.getSimpleName() + " where id = ?";
		session.createQuery(hql).setInteger(0, id);
	}

	@Override
	public T get(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from " + clazz.getSimpleName() + " where id = ?";
		return (T) session.createQuery(hql).setInteger(0, id).uniqueResult();
	}

	@Override
	public List<T> queryAllRecord() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from " + clazz.getSimpleName();
		return session.createQuery(hql).list();
	}

	@Override
	public Long getRecordAmount() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from " + clazz.getSimpleName();
		return (Long) session.createQuery(hql).uniqueResult();
	}

}
