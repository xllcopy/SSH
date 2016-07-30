package com.xll.dao;

import java.util.List;

import com.xll.pojo.AdminAccount;

/**
 *@author xialonglei
 *@since 2016/6/12 
 */
public interface AdminAccountDao extends BasicDao<AdminAccount>{

	/**
	 *@author xialonglei
	 *@since 2016/7/9 
	 */
	List<AdminAccount> queryAdminAccounts(int page, int rows, String loginName);

	/**
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	void deleteAdminAccounts(String ids);

}
