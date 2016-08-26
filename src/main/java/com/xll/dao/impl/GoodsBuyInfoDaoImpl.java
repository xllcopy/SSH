package com.xll.dao.impl;

import java.util.HashSet;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xll.dao.GoodsBuyInfoDao;
import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Order;
import com.xll.pojo.Product;
@Repository
@Transactional
public class GoodsBuyInfoDaoImpl extends BasicDaoImpl<GoodsBuyInfo> implements GoodsBuyInfoDao {

	public GoodsBuyInfoDaoImpl() {
		super(GoodsBuyInfo.class);
	}

	@Override
	public Order addGoodsBuyInfoIntoOrder(Order order, GoodsBuyInfo goodsBuyInfo) {
		
		if(order == null){
			order = new Order(new HashSet<GoodsBuyInfo>());
		}
		for(GoodsBuyInfo oGoodsBuyInfo : order.getGoodsBuyInfos()){
			if(oGoodsBuyInfo.getProduct().getId() == goodsBuyInfo.getProduct().getId()){
				//TODO 一次只能买一个
				goodsBuyInfo.setNumber(oGoodsBuyInfo.getNumber() + 1);
				return order;
			}
		}
		order.getGoodsBuyInfos().add(goodsBuyInfo);
		return order;
	}

	@Override
	public GoodsBuyInfo newGoodsBuyInfoByProduct(Product product) {
		GoodsBuyInfo goodsBuyInfo = new GoodsBuyInfo();
		goodsBuyInfo.setName(product.getProductName());
		goodsBuyInfo.setPrice(product.getProductPrice());
		//TODO 现在默认只能一个一个买
		goodsBuyInfo.setNumber(1);
		goodsBuyInfo.setProduct(product);
		return goodsBuyInfo;
	}


}
