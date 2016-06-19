package com.xll.util;

import java.util.List;

/**
 *@author xialonglei
 *@since 2016/6/17 
 */
public class DataGrid<T> {
	private Long total;
	private List<T> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
