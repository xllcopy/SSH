package com.xll.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xll.dao.AdminAccountDao;
import com.xll.pojo.AdminAccount;

/**
 * @author xialonglei
 * @since 2016/6/12
 */
@Repository
@Transactional
public class AdminAccountDaoImpl extends BasicDaoImpl<AdminAccount>implements AdminAccountDao {
	public AdminAccountDaoImpl() {
		super(AdminAccount.class);
	}
}
