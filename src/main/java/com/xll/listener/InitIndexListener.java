package com.xll.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.xll.task.IndexTimerTask;

/**
 * 获取首页数据
 * 监听器是web层的组件，
 * 它是tomcat实例化的，
 * 不是Spring实例化的，
 * 因此不能放到Spring中
 *@author xialonglei
 *@since 2016/7/23 
 */
public class InitIndexListener implements ServletContextListener{
	
	private IndexTimerTask indexTimerTask;
	private WebApplicationContext acc;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		acc = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		indexTimerTask = (IndexTimerTask) acc.getBean("indexTimerTask");
		indexTimerTask.setApplication(event.getServletContext());
		indexTimerTask.indexDataUpdate();
	}

}
