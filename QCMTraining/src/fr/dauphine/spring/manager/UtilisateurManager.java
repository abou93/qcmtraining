/**
 * 
 */
package fr.dauphine.spring.manager;

import java.util.Collection;


import fr.dauphine.spring.bo.Utilisateur;

/**
 * @author Mathieu
 *
 */
public interface UtilisateurManager extends AbstractManager<Utilisateur>{

	boolean verifLoginAndPassword(String login, String password);
	
	Utilisateur readByEmail(String email);
	
	Utilisateur saveUtilisateur(Utilisateur u);
	
	Collection<Utilisateur> loadAllUtilisateur();
}
