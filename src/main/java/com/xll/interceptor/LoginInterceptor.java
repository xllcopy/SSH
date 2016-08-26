package com.xll.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xll.pojo.User;

/**
 * 对发来的请求做登录判断拦截,如果用户未登陆,
 * 则让它执行登陆,否则按正常流程走
 *@author xialonglei
 *@since 2016/8/13 
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//拦截
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/jsp/loginFrame.jsp").forward(request, response);
			//false表示拦截，不向下执行；true表示放行
			return false;
		}
		return true;
	}

}
