package com.xll.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.pojo.AdminAccount;
import com.xll.service.AdminAccountService;

/**
 *@author xialonglei
 *@since 2016/6/12 
 */
@Controller
@RequestMapping(value = "adminAccount")
public class AdminAccountController {
	
	@Resource
	private AdminAccountService adminAccountServiceImpl;
	@RequestMapping(value = "/save")
	public String save(@RequestParam String loginName ,@RequestParam String name , @RequestParam String pwd){
		AdminAccount adminAccount = new AdminAccount();
		adminAccount.setLoginName(loginName);
		adminAccount.setName(name);
		adminAccount.setPwd(pwd);
		adminAccountServiceImpl.save(adminAccount);
		return "saveSuccess";
	}
	@RequestMapping(value = "/queryAllAdminAccount")
	@ResponseBody
	public List<AdminAccount> queryAllAdminAccount(HttpSession session){
		List<AdminAccount> accounts = adminAccountServiceImpl.queryAllRecord();
		return accounts;
	}
	
}
