package com.xll.dao;

import java.util.List;

import com.xll.pojo.AdminAccount;

/**
 *@author xialonglei
 *@since 2016/6/12 
 */
public interface AdminAccountDao extends BasicDao<AdminAccount>{

	List<AdminAccount> queryAdminAccounts(int page, int rows, String loginName);

	void deleteAdminAccounts(String ids);

}
