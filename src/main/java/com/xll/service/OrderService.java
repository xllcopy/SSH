package com.xll.service;

import com.xll.pojo.Orders;

public interface OrderService extends BasicService<Orders>{
	
	/**
	 *���㹺�ﳵ����Ʒ�ܼ۸�
	 *@param ���ﳵ
	 *@author xialonglei
	 *@since  2016/8/13 
	 */
	public double computeTotalPrice(Orders order);

}
