package com.dao;

import java.util.List;

import com.model.Banji;

public interface BanjiDao {
	
public void insertBean(Banji bean);
	
	public void deleteBean(Banji bean);
	
	public void updateBean(Banji bean);

	public Banji selectBean(String where);
	
	public List<Banji> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
}
