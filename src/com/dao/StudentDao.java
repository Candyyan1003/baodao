package com.dao;

import java.util.List;

import com.model.Student;







public interface StudentDao  {
	
	
	
	public void insertBean(Student bean);
	
	public void deleteBean(Student bean);
	
	public void updateBean(Student bean);

	public Student selectBean(String where);
	
	public List<Student> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
