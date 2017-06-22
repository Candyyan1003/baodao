package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.FenbanDao;
import com.model.Fenban;

public class FenbanDaoImpl extends HibernateDaoSupport implements FenbanDao{

	@Override
	public void insertBean(Fenban bean) {
		this.getHibernateTemplate().save(bean);
	}

	@Override
	public void deleteBean(Fenban bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	@Override
	public void updateBean(Fenban bean) {
		this.getHibernateTemplate().update(bean);
		
	}

	@Override
	public Fenban selectBean(String where) {
		@SuppressWarnings("unchecked")
		List<Fenban> list = this.getHibernateTemplate().find("from Fenban " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Fenban> selectBeanList(final int start, final int limit, final String where) {
		return (List<Fenban>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Fenban> list = session.createQuery("from Fenban "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	@Override
	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Fenban "+where).get(0);
		return (int)count;
	}

}
