package com.xll.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xll.pojo.User;

/**
 * �Է�������������¼�ж�����,����û�δ��½,
 * ������ִ�е�½,��������������
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
		//����
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/jsp/loginFrame.jsp").forward(request, response);
			//false��ʾ���أ�������ִ�У�true��ʾ����
			return false;
		}
		return true;
	}

}
