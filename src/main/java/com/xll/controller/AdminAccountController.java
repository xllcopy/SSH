package com.xll.controller;

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

import com.xll.pojo.AdminAccount;
import com.xll.service.AdminAccountService;
import com.xll.service.CategoryService;
import com.xll.util.Constants;
import com.xll.util.DataGrid;

/**
 *@author xialonglei
 *@since 2016/6/12 
 */
@Controller
@RequestMapping(value = "adminAccount")
public class AdminAccountController {
	@Resource
	private CategoryService categoryServiceImpl;
	@Resource
	private AdminAccountService adminAccountServiceImpl;
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(@RequestBody AdminAccount adminAccount){
		adminAccountServiceImpl.save(adminAccount);
		return Constants.CONSTANTS_TRUE;
	}
	@RequestMapping(value = "/queryAllAdminAccount")
	@ResponseBody
	public List<AdminAccount> queryAllAdminAccount(HttpSession session){
		List<AdminAccount> accounts = adminAccountServiceImpl.queryAllRecord();
		return accounts;
	}
	
	@RequestMapping(value = "/adminManageFrame")
	public String returnAdminManageFrame(HttpSession session){
		return "adminManageFrame";
	}
	
	
	/**
	 *转到管理员界面，查出管理员信息
	 *@param page  第几页
	 *@param rows  每页显示的总记录数
	 *@param loginName  登录名,如果传过来的不为"",表示根据登录名查询
	 *@return 返回管理员json格式
	 *@author xialonglei
	 *@since 2016/7/9
	 */
	@RequestMapping(value = "/queryAdminAccounts")
	@ResponseBody
	public DataGrid<AdminAccount> queryAdminAccounts(HttpSession session, @RequestParam String page,
			@RequestParam String rows , @RequestParam String loginName) {
		DataGrid<AdminAccount> dg = new DataGrid<AdminAccount>();
		List<AdminAccount> adminAccounts = adminAccountServiceImpl.queryAdminAccounts(Integer.parseInt(page),
				Integer.parseInt(rows) , loginName);
		Long total = adminAccountServiceImpl.getRecordAmount();
		dg.setTotal(total);
		dg.setRows(adminAccounts);
		return dg;
	}
	
	
	@RequestMapping(value = "/deleteAdminAccounts")
	@ResponseBody
	public String deleteCategory(HttpSession session , @RequestParam String ids){
		categoryServiceImpl.updateCategories(ids);
		adminAccountServiceImpl.deleteAdminAccounts(ids);
		return Constants.CONSTANTS_TRUE;
	}
	
	/**
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	@RequestMapping(value = "/adminAddFrame")
	public String returnAmdinAddFrame(){
		return "adminAddFrame";
	}
	
	/**
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	@RequestMapping(value = "/adminModifyFrame")
	public String returnAdminModifyFrame(){
		return "adminModifyFrame";
	}
	
	/**
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	@RequestMapping(value="/updateAdminAccount" , method = RequestMethod.POST)
	@ResponseBody
	public String updateAdminAccount(HttpServletRequest request , @RequestBody AdminAccount adminAccount){
		adminAccountServiceImpl.update(adminAccount);
		return Constants.CONSTANTS_TRUE;
	}
	
}
