package com.xll.dao;

import java.util.List;

import com.xll.pojo.Product;

public interface ProductDao extends BasicDao<Product>{

	List<Product> queryProductsJoinCategory(int page, int size, String name);
	void deleteProducts(String ids);
	
	void updateCategories(String ids);
	
	List<Product> queryByCategoryId(long cid);
}
