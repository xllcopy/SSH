package com.xll.dao;

import com.xll.pojo.Order;

public interface OrderDao {
	public double computeTotalPrice(Order order);

}
