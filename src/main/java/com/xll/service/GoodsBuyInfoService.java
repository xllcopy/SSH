package com.xll.service;

import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Order;
import com.xll.pojo.Product;

/**
 *@author xialonglei
 *@since 2016/8/12 
 */
public interface GoodsBuyInfoService extends BasicService<GoodsBuyInfo>{
	
	/**
	 *��Ʒ���ɹ������������빺�ﳵ
	 *@param order ��������û����������֮ǰ���ǳ䵱���ﳵ��ɫ
	 *@param product ��Ʒ�� 
	 */
	public Order addGoodsBuyInfoIntoOrder(Order order ,GoodsBuyInfo goodsBuyInfo);
	
	/**
	 *@param product ��Ʒ��
	 */
	public GoodsBuyInfo newGoodsBuyInfoByProduct(Product product);

}