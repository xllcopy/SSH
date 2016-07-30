package com.xll.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xll.pojo.Product;
import com.xll.service.ProductService;
import com.xll.util.Constants;
import com.xll.util.DataGrid;
import com.xll.util.ImageUpload;

/**
 *@author xialonglei
 *@since 2016/6/25
 */
@Controller
@RequestMapping("product")
public class ProductController {
	@Resource
	private ProductService productServiceImpl;
	
	@RequestMapping(value = "/productManageFrame")
	public String returnProductManageFrame(HttpSession session){
		return "productManageFrame";
	}
	
	
	@RequestMapping(value = "/queryProducts")
	@ResponseBody
	public DataGrid<Product> queryProducts(@RequestParam int page ,@RequestParam int rows ,@RequestParam String name){
		DataGrid<Product> dg = new DataGrid<Product>();
		List<Product> products = productServiceImpl.queryProductsJoinCategory(page , rows , name);
		long count = productServiceImpl.getRecordAmount();
		dg.setTotal(count);
		dg.setRows(products);
		return dg;
	}
	
	@RequestMapping(value = "/productAddFrame")
	public String returnProductAddFrame(HttpSession session){
		return "productAddFrame";
	}
	
	@RequestMapping(value = "/productModifyFrame")
	public String returnproductModifyFrame(HttpSession session){
		return "productModifyFrame";
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody Product product){
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
		String date = null;
		try {
			date = format.format(new Date());
			product.setProductProduceDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		productServiceImpl.save(product);
		return Constants.CONSTANTS_TRUE;
	}
	
	/**
	 *@author xialonglei
	 *@since 2016/7/2
	 */
	@RequestMapping(value = "/deleteProducts")
	@ResponseBody
	public String deleteProducts(HttpSession session , String ids){
		productServiceImpl.deleteProducts(ids);
		return Constants.CONSTANTS_TRUE;
	}
	
	/**
	 *@author xialonglei
	 *@since 2016/7/3 
	 */
	@RequestMapping(value="/updateProduct" , method = RequestMethod.POST)
	@ResponseBody
	public String updateProduct(HttpServletRequest request , @RequestBody Product product){
		productServiceImpl.update(product);
		return Constants.CONSTANTS_TRUE;
	}
	
	
	/**
	 *@author xialonglei
	 *@since 2016/7/8
	 */
	@RequestMapping(value = "/uploadProductPic")
	@ResponseBody
	public String uploadProductPic(@RequestParam MultipartFile uploadProductPicture , HttpServletRequest request , HttpSession session){
		ImageUpload imageUpload = new ImageUpload();
		String newPicPath = imageUpload.upload(uploadProductPicture , request , session);
		return newPicPath;
	}
}
