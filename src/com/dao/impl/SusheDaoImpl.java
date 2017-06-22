package com.dao.impl;

import java.sql.SQLException;
import java.util.List;





import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.SusheDao;
import com.model.Sushe;
import com.model.Ykt;




public class SusheDaoImpl extends HibernateDaoSupport implements  SusheDao{


	public void deleteBean(Sushe bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Sushe bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Sushe selectBean(String where) {
		List<Sushe> list = this.getHibernateTemplate().find("from Sushe " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Sushe "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Sushe> selectBeanList(final int start,final int limit,final String where) {
		return (List<Sushe>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Sushe> list = session.createQuery("from Sushe "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	public void updateBean(Sushe bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
}
