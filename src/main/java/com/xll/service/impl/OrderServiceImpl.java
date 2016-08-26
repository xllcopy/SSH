package com.xll.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.xll.dao.OrderDao;
import com.xll.pojo.Order;
import com.xll.service.OrderService;

@Service
public class OrderServiceImpl extends BasicServiceImpl<Order> implements OrderService{
	
	@Resource
	private OrderDao orderDaoImpl;

	@Override
	public double computeTotalPrice(Order order) {
		return orderDaoImpl.computeTotalPrice(order);
	}

}
