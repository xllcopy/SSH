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
		String hql = "from Product";
		if(name != null && !name.trim().equals("")){
			hql += " where name like ?";
			query = session.createQuery(hql).setString(0, "%" + name + "%");
		}else{
			query = session.createQuery(hql);
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

	@Override
	public void updateCategories(String ids) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update Product set category = null where category in " + "(" + ids + ")";
		session.createQuery(hql).executeUpdate();
	}

	@Override
	public List<Product> queryByCategoryId(long cid) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product p join fetch p.category "  
                + "where p.productDisplay = true and p.productIsValid = true and p.category.id = ? order by p.productProduceDate desc";
		List<Product> products = session.createQuery(hql).setLong(0, cid).setFirstResult(0).setMaxResults(3).list();
		return products;
	}
}
