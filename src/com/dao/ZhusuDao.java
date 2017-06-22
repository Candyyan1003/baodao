package com.dao;

import java.util.List;

import com.model.Zhusu;



public interface ZhusuDao  {
	
	public void insertBean(Zhusu bean);
	
	public void deleteBean(Zhusu bean);
	
	public void updateBean(Zhusu bean);

	public Zhusu selectBean(String where);
	
	public List<Zhusu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
