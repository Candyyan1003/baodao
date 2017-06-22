package com.dao.impl;

import java.sql.SQLException;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.TijianDao;
import com.model.Tijian;













public class TijianDaoImpl extends HibernateDaoSupport implements  TijianDao{


	public void deleteBean(Tijian bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Tijian bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Tijian selectBean(String where) {
		List<Tijian> list = this.getHibernateTemplate().find("from Tijian " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Tijian "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Tijian> selectBeanList(final int start,final int limit,final String where) {
		return (List<Tijian>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Tijian> list = session.createQuery("from Tijian "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Tijian bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
