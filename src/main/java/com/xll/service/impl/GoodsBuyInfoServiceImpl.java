package com.xll.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.dao.GoodsBuyInfoDao;
import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Orders;
import com.xll.pojo.Product;
import com.xll.service.GoodsBuyInfoService;
@Service
public class GoodsBuyInfoServiceImpl extends BasicServiceImpl<GoodsBuyInfo> implements GoodsBuyInfoService {
	
	@Resource
	private GoodsBuyInfoDao goodsBuyInfoDaoImpl;

	@Override
	public Orders addGoodsBuyInfoIntoOrder(Orders order, GoodsBuyInfo goodsBuyInfo) {
		return goodsBuyInfoDaoImpl.addGoodsBuyInfoIntoOrder(order, goodsBuyInfo);
	}

	@Override
	public GoodsBuyInfo newGoodsBuyInfoByProduct(Product product) {
		return goodsBuyInfoDaoImpl.newGoodsBuyInfoByProduct(product);
	}


}
