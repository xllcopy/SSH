package com.xll.service;

import com.xll.pojo.Order;

public interface OrderService extends BasicService<Order>{
	
	/**
	 *���㹺�ﳵ����Ʒ�ܼ۸�
	 *@param ���ﳵ
	 *@author xialonglei
	 *@since  2016/8/13 
	 */
	public double computeTotalPrice(Order order);

}
