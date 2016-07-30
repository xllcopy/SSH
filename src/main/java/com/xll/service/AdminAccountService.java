
package com.xll.service;

import java.util.List;

import com.xll.pojo.AdminAccount;

/**
 *@author xialonglei
 *@since 2016/6/12 
 */
public interface AdminAccountService extends BasicService<AdminAccount>{

	/**
	 *@author xialonglei
	 *@since 2016/7/9 
	 */
	List<AdminAccount> queryAdminAccounts(int page, int rows, String loginName);

	/**
	 *根据adminAccount.id批量删除
	 *@author xialonglei
	 *@since 2016/7/16 
	 */
	void deleteAdminAccounts(String ids);
}
