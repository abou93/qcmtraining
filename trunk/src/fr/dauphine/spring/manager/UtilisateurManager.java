/**
 * 
 */
package fr.dauphine.spring.manager;

import fr.dauphine.spring.bo.Utilisateur;

/**
 * @author Mathieu
 *
 */
public interface UtilisateurManager extends AbstractManager<Utilisateur>{

	boolean verifLoginAndPassword(String login, String password);
	
	Utilisateur readByEmail(String email);
	
}
