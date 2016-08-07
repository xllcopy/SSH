package com.xll.task;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.xll.pojo.Category;
import com.xll.pojo.Product;
import com.xll.service.CategoryService;
import com.xll.service.ProductService;

/**
 * ��ʱ������ҳ����
 *@author xialonglei
 *@since 2016/7/24
 */
@Component
public class IndexTimerTask{
	@Resource  
    private ProductService productServiceImpl; 
    @Resource  
    private CategoryService categoryServiceImpl; 
      
    private ServletContext application = null;
      
    public void setApplication(ServletContext application) {  
        this.application = application;  
    }
    /**ÿ��һ���Ӵ���һ��*/
    @Scheduled(cron="0 0/1 * * * ?")
	public void indexDataUpdate(){
		List<List<Product>> productsList = new ArrayList<List<Product>>();   
        for(Category category : categoryServiceImpl.queryByHot(true)) {   
            List<Product> products = productServiceImpl.queryByCategoryId(category.getId());
            productsList.add(products);  
        }   
        application.setAttribute("productsList", productsList);
	}

}
