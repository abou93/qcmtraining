/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Habilitation;
import fr.dauphine.spring.dao.HabilitationDAO;

/**
 * @author Mathieu
 *
 */
public class HabilitationDAOImpl extends AbstractDAOImpl<Habilitation>
		implements HabilitationDAO {

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Habilitation> getTemplateClass() {
		// TODO Auto-generated method stub
		return Habilitation.class;
	}


	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractDAO#save(java.lang.Object)
	 */
	@Override
	public Habilitation save(Habilitation entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
