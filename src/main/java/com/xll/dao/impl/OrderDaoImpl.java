package com.xll.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xll.dao.OrderDao;
import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Order;

@Repository
@Transactional
public class OrderDaoImpl extends BasicDaoImpl<Order> implements OrderDao{

	public OrderDaoImpl() {
		super(Order.class);
	}

	@Override
	public double computeTotalPrice(Order order) {
		double totalPrice = 0.0;
		for(GoodsBuyInfo goodsBuyInfo : order.getGoodsBuyInfos()){
			totalPrice += goodsBuyInfo.getPrice() * goodsBuyInfo.getNumber();
		}
		return totalPrice;
	}

}
