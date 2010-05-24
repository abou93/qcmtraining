/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.dao.ParticipationDAO;
import fr.dauphine.spring.manager.ParticipationManager;

/**
 * @author Mathieu
 *
 */
public class ParticipationManagerImpl extends AbstractManagerImpl<Participation> implements
		ParticipationManager {

	/**
	 * 
	 */
	public ParticipationManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Participation getParticipationByIdUserAndIdSujet(Long idUser, Long idSujet) {
		return ((ParticipationDAO)dao).getParticipationByIdUserAndIdSujet(idUser, idSujet);
	}

	@Override
	public boolean isParticiperAuSujet(Long idUser, Long idSujet) {
		return ((ParticipationDAO)dao).isParticiperAuSujet(idUser, idSujet);
	}


}
