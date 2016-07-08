package com.xll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.dao.ProductDao;
import com.xll.pojo.Product;
import com.xll.service.ProductService;

/**
 *@author xialonglei
 *@since 2016/6/25 
 */
@Service
public class ProductServiceImpl extends BasicServiceImpl<Product> implements ProductService {

	@Resource
	private ProductDao productDaoImpl;
	
	@Override
	public List<Product> queryProductsJoinCategory(int page, int size, String name) {
		return productDaoImpl.queryProductsJoinCategory(page , size , name);
	}
	
	@Override
	public void deleteProducts(String ids){
		productDaoImpl.deleteProducts(ids);
	}

}
