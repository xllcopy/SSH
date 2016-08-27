package com.xll.dao;

import com.xll.pojo.Orders;

public interface OrderDao extends BasicDao<Orders>{
	public double computeTotalPrice(Orders order);

}
