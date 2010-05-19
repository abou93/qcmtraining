/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.dao.SujetDAO;

/**
 * @author Mathieu
 *
 */
public class SujetDAOImpl extends AbstractDAOImpl<Sujet> implements SujetDAO {

	/**
	 * 
	 */
	public SujetDAOImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Sujet> getTemplateClass() {
		return Sujet.class;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractDAO#save(java.lang.Object)
	 */
	@Override
	public Sujet save(Sujet entity) {
		return super.save(entity);
	}

}
