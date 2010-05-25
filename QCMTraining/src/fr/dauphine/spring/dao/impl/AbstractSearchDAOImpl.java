/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;

import fr.dauphine.spring.dao.AbstractSearchDAO;
import fr.dauphine.spring.form.AbstractSearchForm;

/**
 * @author Mathieu
 *
 */
public abstract class AbstractSearchDAOImpl<T, TypeObjectForm extends AbstractSearchForm> extends AbstractDAOImpl<T> implements
		AbstractSearchDAO<T, TypeObjectForm> {

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractSearchDAO#search(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> search(TypeObjectForm form) {
		Criteria crit = getSession().createCriteria(getTemplateClass());
		constructCriteria(crit, form);
		return (Collection<T>)crit.list();
	}
		
	/**
	 * 
	 */
	public AbstractSearchDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	abstract protected void constructCriteria(Criteria crit, TypeObjectForm form);

}
