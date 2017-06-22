package com.dao.impl;

import java.sql.SQLException;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.YktDao;
import com.model.Ykt;













public class YktDaoImpl extends HibernateDaoSupport implements  YktDao{


	public void deleteBean(Ykt bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Ykt bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Ykt selectBean(String where) {
		List<Ykt> list = this.getHibernateTemplate().find("from Ykt " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Ykt "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Ykt> selectBeanList(final int start,final int limit,final String where) {
		return (List<Ykt>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Ykt> list = session.createQuery("from Ykt "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Ykt bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
