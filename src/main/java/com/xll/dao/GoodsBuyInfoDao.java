package com.xll.dao;

import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Order;
import com.xll.pojo.Product;

/**
 *@author xialonglei
 *@since 2016/8/12 
 */
public interface GoodsBuyInfoDao extends BasicDao<GoodsBuyInfo>{
	public Order addGoodsBuyInfoIntoOrder(Order order ,GoodsBuyInfo goodsBuyInfo);
	public GoodsBuyInfo newGoodsBuyInfoByProduct(Product product);
}
