/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.dao.UtilisateurDAO;
import fr.dauphine.spring.manager.UtilisateurManager;

/**
 * @author Mathieu
 *
 */
public class UtilisateurManagerImpl extends AbstractManagerImpl<Utilisateur> implements UtilisateurManager {

	/**
	 * 
	 */
	public UtilisateurManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.manager.UtilisateurManager#verifLoginAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verifLoginAndPassword(String login, String password){
		return ((UtilisateurDAO)dao).verifLoginAndPassword(login, password);
	}

	@Override
	public Utilisateur readByEmail(String email) {
		return ((UtilisateurDAO)dao).readByEmail(email);
	}
	
	
}
