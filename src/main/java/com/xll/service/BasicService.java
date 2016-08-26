package com.xll.service;

import java.util.List;

/**
 *@author xialonglei
 *@since 2016/6/11
 *基础业务逻辑接口，包含基础性的操作 
 */
public interface BasicService<T> {   
	public abstract void save(T t);  
	  
    public abstract void update(T t);  
      
    public abstract void delete(int id);  
      
    public abstract T get(long id);  
      
    public abstract List<T> queryAllRecord();
    
    /**
     *@author xialonglei
     *@since 2016/6/18 
     */
    public abstract Long getRecordAmount();
}
