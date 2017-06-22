package com.dao;

import java.util.List;

import com.model.Dangan;







public interface DanganDao  {
	
	
	
	public void insertBean(Dangan bean);
	
	public void deleteBean(Dangan bean);
	
	public void updateBean(Dangan bean);

	public Dangan selectBean(String where);
	
	public List<Dangan> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
