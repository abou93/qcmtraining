/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.dao.ParticipationDAO;

/**
 * @author Mathieu
 *
 */
public class ParticipationDAOImpl extends AbstractDAOImpl<Participation>
		implements ParticipationDAO {

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Participation> getTemplateClass() {
		return Participation.class;
	}

}
