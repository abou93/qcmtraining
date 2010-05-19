/**
 * 
 */
package fr.dauphine.spring.dao;

import fr.dauphine.spring.bo.Utilisateur;

/**
 * @author Mathieu
 *
 */
public interface UtilisateurDAO extends AbstractDAO<Utilisateur> {
	boolean verifLoginAndPassword(String login, String password);
	
	Utilisateur readByEmail(String email);
}
