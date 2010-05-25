/**
 * 
 */
package fr.dauphine.spring.manager;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.form.UtilisateurSearchForm;

/**
 * @author Mathieu
 *
 */
public interface UtilisateurManager extends AbstractSearchManager<Utilisateur, UtilisateurSearchForm>{

	boolean verifLoginAndPassword(String login, String password);
	
	Utilisateur readByEmail(String email);
	
}
