/**
 * 
 */
package fr.dauphine.spring.dao;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.form.UtilisateurSearchForm;

/**
 * @author Mathieu
 *
 */
public interface UtilisateurDAO extends AbstractSearchDAO<Utilisateur, UtilisateurSearchForm> {
	boolean verifLoginAndPassword(String login, String password);
	
	Utilisateur readByEmail(String email);
}
