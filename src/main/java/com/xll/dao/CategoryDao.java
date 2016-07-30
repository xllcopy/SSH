package com.xll.dao;
import java.util.List;

import com.xll.pojo.Category;
/**
 *@author xialonglei
 *@since  2016/6/11
 */
public interface CategoryDao extends BasicDao<Category>{
	/**
	 *��ѯ�����Ϣ����������Ա������ҳ
	 *@author xialonglei
	 *@since 2016/6/12
	 */  
    public List<Category> queryJoinAdminAccount(int page , int size , String type);
    
    /**
	 *����id��ɾ�����࣬��������
	 *@author xialonglei
	 *@since 2016/6/18 
	 */
	public void deleteCategory(String ids);

	public void updateCategories(String ids);
	
	/**
	 *����hot��ѯ��Category
	 *@author xialonglei
	 *@since 2016/7/17 
	 */
	public List<Category> queryByHot(boolean hot);
}
