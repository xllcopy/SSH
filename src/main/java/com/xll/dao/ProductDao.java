package com.xll.dao;

import java.util.List;

import com.xll.pojo.Product;

public interface ProductDao extends BasicDao<Product>{

	List<Product> queryProductsJoinCategory(int page, int size, String name);
	void deleteProducts(String ids);
	/**
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	void updateCategories(String ids);
	/**
	 *¸ù¾ÝCategory.id²éÑ¯Product
	 *@author xialonglei
	 *@since 2016/7/17 
	 */
	List<Product> queryByCategoryId(long cid);
}
