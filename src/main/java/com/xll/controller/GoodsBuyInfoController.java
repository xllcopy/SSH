package com.xll.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Order;
import com.xll.pojo.Product;
import com.xll.service.GoodsBuyInfoService;
import com.xll.service.ProductService;

/**
 *���ﳵ������
 *@author xialonglei
 *@since 2017/8/12 
 */
@Controller
@RequestMapping("/cart")
public class GoodsBuyInfoController {
	
	@Resource
	private GoodsBuyInfoService goodsBuyInfoServiceImpl;
	@Resource
	private ProductService productServiceImpl;
	
	/**
	 *@param session session���Ǳ����Ź��ﳵ 
	 */
	@RequestMapping(value = "/addProduct" , method = RequestMethod.GET)
	public String addIntoCart(@RequestParam(name = "id") String productId , HttpSession session){
		Product product = productServiceImpl.get(Long.parseLong(productId));
		GoodsBuyInfo goodsBuyInfo = goodsBuyInfoServiceImpl.newGoodsBuyInfoByProduct(product);
		Order order = (Order) session.getAttribute("order");
		//�����µĻ���µĹ��ﳵ
		order = goodsBuyInfoServiceImpl.addGoodsBuyInfoIntoOrder(order, goodsBuyInfo);
		//�����ܽ��
		
		session.setAttribute("order", order);
		//�������ﳵ����
		return "showCart";
	}

}
