package com.xll.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	@Resource
	private SessionFactory sessionFactory;
	
	
	public AdminAccountDaoImpl() {
		super(AdminAccount.class);
		
	}
	
	@Override
	public List<AdminAccount> queryAdminAccounts(int page, int rows, String loginName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		String hql = "from AdminAccount";
		if(!"".equals(loginName)){
			hql += " where loginName like ?";
			query = session.createQuery(hql).setString(0, "%" + loginName + "%").setFirstResult(page).setMaxResults(rows);
		}else{
			query = session.createQuery(hql).setFirstResult((page - 1) * rows).setMaxResults(rows);
		}
		List<AdminAccount> adminAccounts = query.list();
		return adminAccounts;
	}

	@Override
	public void deleteAdminAccounts(String ids) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from AdminAccount where id in " + "(" + ids + ")";
		session.createQuery(hql).executeUpdate();
	}
}
