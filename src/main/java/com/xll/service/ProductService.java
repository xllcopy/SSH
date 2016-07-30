package com.xll.service;

import java.util.List;

import com.xll.pojo.Product;

/**
 * @author xialonglei
 * @since 2016/6/25
 */
public interface ProductService extends BasicService<Product>{
	
	/**
	 * 根据分页获取商品，并且级联查出其分类
	 * 如果如果参数name不为空，那么就是带name的条件查询
	 *@author xialonglei
	 *@since 2016/6/25 
	 */
	List<Product> queryProductsJoinCategory(int page , int size , String name);
	
	/**
	 *@author xialonglei
	 *@since 2016/7/2 
	 */
	void deleteProducts(String ids);
	
	/**
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	void updateCategories(String ids);
	
	/**
	 *根据Category.id查出Product
	 *@author xialonglei
	 *@since 2016/7/17
	 */
	List<Product> queryByCategoryId(long cid);

}
