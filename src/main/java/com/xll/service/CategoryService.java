package com.xll.service;

import java.util.List;

import com.xll.pojo.Category;

/**
 * @author xialonglei
 * @since 2016/6/10
 */
public interface CategoryService extends BasicService<Category>{
	/**
	 * ��ѯ�����Ϣ����������Ա
	 * 
	 * @author xialonglei
	 * @since 2016/6/12
	 */
	public List<Category> queryJoinAdminAccount(int page, int size , String type);
	
	/**
	 *����id��ɾ�����࣬��������
	 *@author xialonglei
	 *@since 2016/6/18 
	 */
	public void deleteCategory(String ids);
}
