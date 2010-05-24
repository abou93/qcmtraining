/**
 * 
 */
package fr.dauphine.spring.dao;

import java.util.List;

import fr.dauphine.spring.bo.Participation;

/**
 * @author Mathieu
 *
 */
public interface ParticipationDAO extends AbstractDAO<Participation> {

	Participation getParticipationByIdUserAndIdSujet(Long idUser, Long idSujet);
	boolean isParticiperAuSujet(Long idUser, Long idSujet);
	List<Participation> getParticipationSansFaute(Long idSujet, int nbQuestionDisplay);

}
