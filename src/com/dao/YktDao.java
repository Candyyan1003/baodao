package com.dao;

import java.util.List;

import com.model.Ykt;







public interface YktDao  {
	
	
	
	public void insertBean(Ykt bean);
	
	public void deleteBean(Ykt bean);
	
	public void updateBean(Ykt bean);

	public Ykt selectBean(String where);
	
	public List<Ykt> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
