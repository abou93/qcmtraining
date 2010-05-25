/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import java.util.Collection;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.dao.AbstractSearchDAO;
import fr.dauphine.spring.form.AbstractSearchForm;
import fr.dauphine.spring.manager.AbstractSearchManager;

/**
 * @author Mathieu
 *
 */
public abstract class AbstractSearchManagerImpl<T extends BO, TypeObjectForm extends AbstractSearchForm> extends AbstractManagerImpl<T> implements
		AbstractSearchManager<T, TypeObjectForm> {
	/**
	 * 
	 */
	public AbstractSearchManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.manager.AbstractSearchManager#search(fr.dauphine.spring.form.AbstractSearchForm)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> search(TypeObjectForm form) {
		return ((AbstractSearchDAO)dao).search(form);
	}
	

}
