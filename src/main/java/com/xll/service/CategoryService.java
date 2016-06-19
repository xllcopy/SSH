package com.xll.service;

import java.util.List;

import com.xll.pojo.Category;

/**
 * @author xialonglei
 * @since 2016/6/10
 */
public interface CategoryService extends BasicService<Category>{
	/**
	 * 查询类别信息，级联管理员
	 * 
	 * @author xialonglei
	 * @since 2016/6/12
	 */
	public List<Category> queryJoinAdminAccount(int page, int size , String type);
	
	/**
	 *根据id，删除分类，可以批量
	 *@author xialonglei
	 *@since 2016/6/18 
	 */
	public void deleteCategory(String ids);
}
