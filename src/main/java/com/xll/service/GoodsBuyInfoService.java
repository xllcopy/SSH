package com.xll.service;

import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Orders;
import com.xll.pojo.Product;

/**
 *@author xialonglei
 *@since 2016/8/12 
 */
public interface GoodsBuyInfoService extends BasicService<GoodsBuyInfo>{
	
	/**
	 *商品生成购买项，购买项放入购物车
	 *@param order 订单，在没有真正购买之前它是充当购物车角色
	 *@param product 商品类 
	 */
	public Orders addGoodsBuyInfoIntoOrder(Orders order ,GoodsBuyInfo goodsBuyInfo);
	
	/**
	 *@param product 商品类
	 */
	public GoodsBuyInfo newGoodsBuyInfoByProduct(Product product);

}
