/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import java.util.Collection;

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
	private UtilisateurDAO utilisateurDAO;
	
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

	@Override
	public Collection<Utilisateur> loadAllUtilisateur() {
		return utilisateurDAO.loadAll();
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur u) {
		return utilisateurDAO.save(u);
	}
	
	public void setUtilisateurDAO(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	
}
