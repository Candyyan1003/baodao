package com.dao.impl;

import java.sql.SQLException;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.JiaofeiDao;
import com.model.Jiaofei;













public class JiaofeiDaoImpl extends HibernateDaoSupport implements  JiaofeiDao{


	public void deleteBean(Jiaofei bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Jiaofei bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Jiaofei selectBean(String where) {
		List<Jiaofei> list = this.getHibernateTemplate().find("from Jiaofei " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Jiaofei "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Jiaofei> selectBeanList(final int start,final int limit,final String where) {
		return (List<Jiaofei>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Jiaofei> list = session.createQuery("from Jiaofei "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Jiaofei bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
