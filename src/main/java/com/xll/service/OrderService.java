package com.xll.service;

import com.xll.pojo.Order;

public interface OrderService extends BasicService<Order>{
	
	/**
	 *计算购物车中商品总价格
	 *@param 购物车
	 *@author xialonglei
	 *@since  2016/8/13 
	 */
	public double computeTotalPrice(Order order);

}
