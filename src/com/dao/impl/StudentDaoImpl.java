package com.dao.impl;

import java.sql.SQLException;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.StudentDao;
import com.model.Student;


public class StudentDaoImpl extends HibernateDaoSupport implements  StudentDao{


	public void deleteBean(Student bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Student bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Student selectBean(String where) {
		List<Student> list = this.getHibernateTemplate().find("from Student " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Student "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Student> selectBeanList(final int start,final int limit,final String where) {
		return (List<Student>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Student> list = session.createQuery("from Student "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Student bean) {
		this.getHibernateTemplate().update(bean);
		
	}
}
