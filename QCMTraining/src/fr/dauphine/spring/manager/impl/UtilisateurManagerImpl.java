/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.dao.UtilisateurDAO;
import fr.dauphine.spring.form.UtilisateurSearchForm;
import fr.dauphine.spring.manager.UtilisateurManager;

/**
 * @author Mathieu
 *
 */
public class UtilisateurManagerImpl extends AbstractSearchManagerImpl<Utilisateur, UtilisateurSearchForm> implements UtilisateurManager {

	
	public UtilisateurManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verifLoginAndPassword(String login, String password){
		return ((UtilisateurDAO)dao).verifLoginAndPassword(login, password);
	}

	@Override
	public Utilisateur readByEmail(String email) {
		return ((UtilisateurDAO)dao).readByEmail(email);
	}
}
