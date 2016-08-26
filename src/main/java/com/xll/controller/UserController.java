package com.xll.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.pojo.User;
import com.xll.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userServiceImpl;
	
	@RequestMapping("/loginFrame")
	public String returnLoginFrame(){
		return "loginFrame";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpSession session , @RequestParam String loginName , @RequestParam String password){
		User user = userServiceImpl.login(loginName, password);
		if(user == null){
			return "fail";
		}
		session.setAttribute("user", user);
		return "success";
	}
}
