package com.dao;

import java.util.List;

import com.model.Tijian;







public interface TijianDao  {
	
	
	
	public void insertBean(Tijian bean);
	
	public void deleteBean(Tijian bean);
	
	public void updateBean(Tijian bean);

	public Tijian selectBean(String where);
	
	public List<Tijian> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
