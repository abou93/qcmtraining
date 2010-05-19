package fr.dauphine.spring.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.dauphine.spring.dao.AbstractDAO;

@SuppressWarnings("unchecked")
public abstract class AbstractDAOImpl<T> extends HibernateDaoSupport implements AbstractDAO<T> {

	public Collection<T> loadAll() {
		return getHibernateTemplate().loadAll(getTemplateClass());
	}
	
	@Override
	public T save(T entity) {
		getHibernateTemplate().save(entity);
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractDAO#read(java.lang.String)
	 */
	@Override
	public T read(String id) {
		Criteria crit = getSession().createCriteria(getTemplateClass());
		crit.add(Restrictions.eq("id", id));
		return (T)crit.uniqueResult();
	}

	abstract protected Class getTemplateClass();
}
