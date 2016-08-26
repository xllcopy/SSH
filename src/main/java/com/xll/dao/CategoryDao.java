package com.xll.dao;
import java.util.List;

import com.xll.pojo.Category;
/**
 *@author xialonglei
 *@since  2016/6/11
 */
public interface CategoryDao extends BasicDao<Category>{
    public List<Category> queryJoinAdminAccount(int page , int size , String type);
    
	public void deleteCategory(String ids);

	public void updateCategories(String ids);
	
	public List<Category> queryByHot(boolean hot);
}
