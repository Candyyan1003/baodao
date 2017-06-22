package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.BanjiDao;
import com.model.Banji;

public class BanjiDaoImpl extends HibernateDaoSupport implements BanjiDao{
	
	@Override
	public void deleteBean(Banji bean) {

		this.getHibernateTemplate().delete(bean);
	}
	
	@Override
	public void insertBean(Banji bean) {

		this.getHibernateTemplate().save(bean);
	}
	
	@Override
	public Banji selectBean(String where) {
		@SuppressWarnings("unchecked")
		List<Banji> list = this.getHibernateTemplate().find("from Banji " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}
	@Override
	public int selectBeanCount(String where) {
		
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Banji "+where).get(0);
		return (int)count;
	}
	@Override
	public void updateBean(Banji bean) {
		this.getHibernateTemplate().update(bean);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Banji> selectBeanList(final int start, final int limit, final String where) {
		return (List<Banji>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Banji> list = session.createQuery("from Banji "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				System.out.println(list.size());
				return list;
			}
		});
	}	
}
