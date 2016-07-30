package com.xll.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.xll.task.IndexTimerTask;

/**
 * ��ȡ��ҳ����
 * ��������web��������
 * ����tomcatʵ�����ģ�
 * ����Springʵ�����ģ�
 * ��˲��ܷŵ�Spring��
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
