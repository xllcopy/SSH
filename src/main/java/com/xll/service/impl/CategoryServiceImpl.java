package com.xll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.dao.CategoryDao;
import com.xll.pojo.Category;
import com.xll.service.CategoryService;

/**
 * @author xialonglei
 * @since 2016/6/11
 */
@Service
public class CategoryServiceImpl extends BasicServiceImpl<Category> implements CategoryService {
	@Resource
	private CategoryDao categoryDaoImpl;

	@Override
	public List<Category> queryJoinAdminAccount(int page, int size , String type) {
		return categoryDaoImpl.queryJoinAdminAccount(page, size , type);
	}

	@Override
	public void deleteCategory(String ids) {
		categoryDaoImpl.deleteCategory(ids);
	}

	@Override
	public void updateCategories(String ids) {
		categoryDaoImpl.updateCategories(ids);
		
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		return categoryDaoImpl.queryByHot(hot);
	}

}
