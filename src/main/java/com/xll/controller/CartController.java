package com.xll.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.pojo.GoodsBuyInfo;
import com.xll.pojo.Orders;
import com.xll.pojo.Product;
import com.xll.pojo.User;
import com.xll.service.GoodsBuyInfoService;
import com.xll.service.OrderService;
import com.xll.service.ProductService;

/**
 *���ﳵ������
 *@author xialonglei
 *@since 2017/8/12 
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource
	private GoodsBuyInfoService goodsBuyInfoServiceImpl;
	@Resource
	private ProductService productServiceImpl;
	@Resource
	private OrderService orderServiceImpl;
	
	/**
	 *@param session session���Ǳ����Ź��ﳵ 
	 */
	@RequestMapping(value = "/addProduct" , method = RequestMethod.GET)
	public String addIntoCart(@RequestParam(name = "id") String productId , HttpSession session){
		Product product = productServiceImpl.get(Long.parseLong(productId));
		GoodsBuyInfo goodsBuyInfo = goodsBuyInfoServiceImpl.newGoodsBuyInfoByProduct(product);
		Orders order = (Orders) session.getAttribute("order");
		//�����µĻ���µĹ��ﳵ
		order = goodsBuyInfoServiceImpl.addGoodsBuyInfoIntoOrder(order, goodsBuyInfo);
		//�����ܽ��
		order.setTotal(orderServiceImpl.computeTotalPrice(order));
		session.setAttribute("order", order);
		//�������ﳵ����
		return "showCart";
	}
	@RequestMapping(value = "/showCart")
	public String returnShowCart(){
		return "showCart";
	}
	
	@RequestMapping(value = "/payInfoFrame")
	public String returnPayInfoFrame(HttpSession session){
		String token = (new Date()).getTime() + "" + UUID.randomUUID();
		session.setAttribute("token", token);
		return "payInfoFrame";
	}
	
	@RequestMapping(value = "/orderSubmit" , method=RequestMethod.POST)
	@ResponseBody
	public String orderSubmit(HttpSession session ,@RequestParam String name , @RequestParam String mobile , 
			@RequestParam String postcode , @RequestParam String address , @RequestParam String token){
		if(!token.equals(session.getAttribute("token"))){
			return "failed";
		}
		token = new Date().getTime() + "" + UUID.randomUUID();
		session.setAttribute("token", token);
		Orders order = (Orders) session.getAttribute("order");
		order.setReceiverName(name);
		order.setReceiverPhone(mobile);
		order.setPostCode(postcode);
		order.setReceiverAddress(address);
		order.setUid((User)session.getAttribute("user"));
		orderServiceImpl.save(order);
		return "success";
	}
}

