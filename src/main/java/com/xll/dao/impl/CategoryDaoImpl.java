package com.xll.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xll.dao.CategoryDao;
import com.xll.pojo.Category;

/**
 * @author xialonglei
 * @since 2016/6/11
 */
@Transactional
@Repository
public class CategoryDaoImpl extends BasicDaoImpl<Category> implements CategoryDao {
	
	public CategoryDaoImpl() {
		super(Category.class);
	}

	@Override
	public List<Category> queryJoinAdminAccount(int page, int size , String type) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		String hql = "from Category";
		if(type != null && !type.trim().equals("")){
			hql += " where type like ?";
			query = session.createQuery(hql).setString(0, "%" + type + "%");
		}else{
			query = session.createQuery(hql);
		}
		return query.setFirstResult((page - 1) * size).setMaxResults(size).list();
	}

	@Override
	public void deleteCategory(String ids) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Category where id in (" + ids + ")";
		session.createQuery(hql).executeUpdate();
	}
}
