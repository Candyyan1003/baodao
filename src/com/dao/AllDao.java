package com.dao;

import java.util.List;

import com.model.All;

public interface AllDao {
	
public void insertBean(All bean);
	
	public void deleteBean(All bean);
	
	public void updateBean(All bean);

	public All selectBean(String where);
	
	public List<All> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
}
