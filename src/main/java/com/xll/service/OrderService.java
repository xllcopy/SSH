package com.xll.service;

import com.xll.pojo.Orders;

public interface OrderService extends BasicService<Orders>{
	
	/**
	 *计算购物车中商品总价格
	 *@param 购物车
	 *@author xialonglei
	 *@since  2016/8/13 
	 */
	public double computeTotalPrice(Orders order);

}
