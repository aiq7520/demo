package ssm.utils;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

public class HibernateCallbackImpl<T> implements HibernateCallback<T>{
	private String hql;
	private int start;
	private int size=20;
	public HibernateCallbackImpl(String hql,int start){
		this.hql = hql;
		this.start=start;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T doInHibernate(Session session) throws HibernateException {
		Query query = session.createQuery(hql);
		query.setFirstResult(start);
        query.setMaxResults(size);
		return   (T) query.list();
	}
	
}
