package com.xll.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.xll.dao.BasicDao;
import com.xll.service.BasicService;

/**
 * @author xialonglei
 * @since 2016/6/10
 */
@Lazy(true)
@Service("basicSerivce")
public class BasicServiceImpl<T> implements BasicService<T> {
	@Lazy(true)
	@Autowired
	private BasicDao<T> basicDaoImpl;

	@Override
	public void save(T t) {
		basicDaoImpl.save(t);
	}

	@Override
	public void update(T t) {
		basicDaoImpl.update(t);
	}

	@Override
	public void delete(int id) {
	}

	@Override
	public T get(long id) {
		return basicDaoImpl.get(id);
	}

	@Override
	public List<T> queryAllRecord() {
		return basicDaoImpl.queryAllRecord();
	}

	@Override
	public Long getRecordAmount() {
		return basicDaoImpl.getRecordAmount();
	}

}
