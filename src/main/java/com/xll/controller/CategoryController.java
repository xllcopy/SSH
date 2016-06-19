package com.xll.controller;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xll.pojo.AdminAccount;
import com.xll.pojo.Category;
import com.xll.service.CategoryService;
import com.xll.util.Constants;
import com.xll.util.DataGrid;

/**
 * @author xialonglei
 * @since 2016/6/10
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController {
	@Resource
	private CategoryService categoryServiceImpl;

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(@RequestParam String type, @RequestParam boolean hot, @RequestParam long id) {
		Category category = new Category(type, hot, new AdminAccount(id));
		categoryServiceImpl.save(category);
		return Constants.CONSTANTS_TRUE;
	}

	@RequestMapping(value = "/queryJoinAdminAccount")
	@ResponseBody
	public DataGrid<Category> queryJoinAdminAccount(HttpSession session, @RequestParam String page,
			@RequestParam String rows , @RequestParam String type) {
		DataGrid<Category> dg = new DataGrid<Category>();
		List<Category> categories = categoryServiceImpl.queryJoinAdminAccount(Integer.parseInt(page),
				Integer.parseInt(rows) , type);
		Long total = categoryServiceImpl.getRecordAmount();
		dg.setTotal(total);
		dg.setRows(categories);
		return dg;
	}

	@RequestMapping(value = "/queryFrame")
	public String queryFrame(HttpSession session) {
		return "categoryQueryFrame";
	}
	
	@RequestMapping(value = "/deleteCategory")
	@ResponseBody
	public String deleteCategory(HttpSession session , @RequestParam String ids){
		categoryServiceImpl.deleteCategory(ids);
		return Constants.CONSTANTS_TRUE;
	}
	
	@RequestMapping(value = "/addFrame")
	public String addFrame(){
		return "categoryAddFrame";
	}
	
	@RequestMapping(value = "returnAindex")
	public String returnAindex(){
		return "aindex";
	}
	
	@RequestMapping(value = "/modifiedFrame")
	public String modifiedFrame(){
		return "categoryModifiyFrame";
	}
	
	@RequestMapping(value = "/updateCategory")
	@ResponseBody
	public String updateCategory(HttpSession session , @RequestParam String type , @RequestParam boolean hot , @RequestParam long categoryID , @RequestParam long adminID){
		categoryServiceImpl.update(new Category(categoryID , type , hot , new AdminAccount(adminID)));
		return Constants.CONSTANTS_TRUE;
	}
	
}
