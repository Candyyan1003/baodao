package com.dao;

import java.util.List;

import com.model.Sushe;



public interface SusheDao  {
	
	
	
	public void insertBean(Sushe bean);
	
	public void deleteBean(Sushe bean);
	
	public void updateBean(Sushe bean);
		
	public Sushe selectBean(String where);
	
	public List<Sushe> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
