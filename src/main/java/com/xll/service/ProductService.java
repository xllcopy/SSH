package com.xll.service;

import java.util.List;

import com.xll.pojo.Product;

/**
 * @author xialonglei
 * @since 2016/6/25
 */
public interface ProductService extends BasicService<Product>{
	
	/**
	 * ���ݷ�ҳ��ȡ��Ʒ�����Ҽ�����������
	 * ����������name��Ϊ�գ���ô���Ǵ�name��������ѯ
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
	 *����Category.id���Product
	 *@author xialonglei
	 *@since 2016/7/17
	 */
	List<Product> queryByCategoryId(long cid);

}
