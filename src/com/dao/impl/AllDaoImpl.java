package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AllDao;
import com.model.All;

public class AllDaoImpl extends HibernateDaoSupport implements AllDao{
	
	@Override
	public void deleteBean(All bean) {

		this.getHibernateTemplate().delete(bean);
	}
	
	@Override
	public void insertBean(All bean) {

		this.getHibernateTemplate().save(bean);
	}
	
	@Override
	public All selectBean(String where) {
		@SuppressWarnings("unchecked")
		List<All> list = this.getHibernateTemplate().find("from All " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}
	@Override
	public int selectBeanCount(String where) {
		
		long count = (Long)this.getHibernateTemplate().find("select count(*) from All "+where).get(0);
		return (int)count;
	}
	@Override
	public void updateBean(All bean) {
		this.getHibernateTemplate().update(bean);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<All> selectBeanList(final int start, final int limit, final String where) {
		return (List<All>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<All> list = session.createQuery("from All "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}	
}
