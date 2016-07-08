package com.xll.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.xll.dao.ProductDao;
import com.xll.pojo.Product;

@Repository
@Transactional
public class ProductDaoImpl extends BasicDaoImpl<Product> implements ProductDao{

	public ProductDaoImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> queryProductsJoinCategory(int page, int size, String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = null;
		Query query = null;
		String sql = "from Product";
		if(name != null && !name.trim().equals("")){
			sql += " where name like ?";
			query = session.createQuery(sql).setString(0, "%" + name + "%");
		}else{
			query = session.createQuery(sql);
		}
		products = (List<Product>) query.setFirstResult((page - 1) * size).setMaxResults(size).list();
		return products;
	}
	
	@Override
	public void deleteProducts(String ids){
		Session session = sessionFactory.getCurrentSession();
		String sql = "delete from Product where id in " + "(" + ids + ")";
		session.createQuery(sql).executeUpdate();
	}
}
