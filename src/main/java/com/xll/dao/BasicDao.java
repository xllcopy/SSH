package com.xll.dao;

import java.util.List;
/**
 *@author xialonglei
 *@since  2016/6/10
 */
public interface  BasicDao<T> {
	public abstract void save(T t);  
	  
    public abstract void update(T t);  
      
    public abstract void delete(int id);  
      
    public abstract T get(int id);  
      
    public abstract List<T> queryAllRecord();
    
    /**
     *@author xialonglei
     *@since 2016/6/18 
     */
    public abstract Long getRecordAmount();
}
