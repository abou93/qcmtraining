/**
 * 
 */
package fr.dauphine.spring.manager;

import java.util.List;

import fr.dauphine.spring.bo.Participation;

/**
 * @author Mathieu
 *
 */
public interface ParticipationManager extends AbstractManager<Participation> {

	Participation getParticipationByIdUserAndIdSujet(Long idUser, Long idSujet);
	
	boolean isParticiperAuSujet(Long idUser, Long idSujet);
	
	List<Participation> getParticipationSansFaute(Long idSujet, int nbQuestionDisplay);
}
