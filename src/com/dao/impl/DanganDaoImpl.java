package com.dao.impl;

import java.sql.SQLException;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.DanganDao;
import com.model.Dangan;













public class DanganDaoImpl extends HibernateDaoSupport implements  DanganDao{


	public void deleteBean(Dangan bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Dangan bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Dangan selectBean(String where) {
		List<Dangan> list = this.getHibernateTemplate().find("from Dangan " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Dangan "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Dangan> selectBeanList(final int start,final int limit,final String where) {
		return (List<Dangan>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Dangan> list = session.createQuery("from Dangan "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Dangan bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
