package com.xll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.dao.AdminAccountDao;
import com.xll.pojo.AdminAccount;
import com.xll.service.AdminAccountService;
/**
 *@author xialonglei
 *@since 2016/6/12 
 */
@Service
public class AdminAccountServiceImpl extends BasicServiceImpl<AdminAccount> implements AdminAccountService{
	
	@Resource
	private AdminAccountDao adminAccountDaoImpl;

	@Override
	public List<AdminAccount> queryAdminAccounts(int page, int rows, String loginName) {
		return adminAccountDaoImpl.queryAdminAccounts(page , rows , loginName);
	}

	@Override
	public void deleteAdminAccounts(String ids) {
		adminAccountDaoImpl.deleteAdminAccounts(ids);
		
	}

}
