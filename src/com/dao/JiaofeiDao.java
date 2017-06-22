package com.dao;

import java.util.List;

import com.model.Jiaofei;



public interface JiaofeiDao  {
	
	
	
	public void insertBean(Jiaofei bean);
	
	public void deleteBean(Jiaofei bean);
	
	public void updateBean(Jiaofei bean);

	public Jiaofei selectBean(String where);
	
	public List<Jiaofei> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
