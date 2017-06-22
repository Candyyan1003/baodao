package com.dao.impl;

import java.sql.SQLException;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ZhusuDao;
import com.model.Zhusu;



public class ZhusuDaoImpl extends HibernateDaoSupport implements  ZhusuDao{


	public void deleteBean(Zhusu bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Zhusu bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Zhusu selectBean(String where) {
		List<Zhusu> list = this.getHibernateTemplate().find("from Zhusu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Zhusu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Zhusu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Zhusu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Zhusu> list = session.createQuery("from Zhusu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Zhusu bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
}
