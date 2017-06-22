package com.dao;

import java.util.List;

import com.model.Fenban;

public interface FenbanDao{

public void insertBean(Fenban bean);
	
	public void deleteBean(Fenban bean);
	
	public void updateBean(Fenban bean);

	public Fenban selectBean(String where);
	
	public List<Fenban> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
}
