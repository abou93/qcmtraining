/**
 * 
 */
package fr.dauphine.spring.bo.validator;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.UtilisateurManager;

/**
 * @author Mathieu
 *
 */
public class UserValidator implements Validator {
	
	UtilisateurManager utilisateurManager;
	/**
	 * 
	 */
	public UserValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.equals(Utilisateur.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Utilisateur util = (Utilisateur) arg0;
		if (util == null) {
			errors.rejectValue("email", "Erreur !", null, "Veuillez renseigner un login et un mot de passe!");
		}
		else {
			if (util.getNom() == null || util.getNom().equals("")) {
				errors.rejectValue("email", "Valeur manquante", null, "Il faut saisir un email");
			}
			if (util.getEmail() == null || util.getEmail().equals("")) {
				errors.rejectValue("email", "Valeur manquante", null, "Il faut saisir un email");
			}
			if (util.getPassword() == null || util.getPassword().equals("")) {
				errors.rejectValue("password", "Valeur manquante", null, "Il faut saisir un password");
			}
		}
		Collection<Utilisateur> col = utilisateurManager.loadAllUtilisateur();
		Iterator<Utilisateur> it = col.iterator();
		while(it.hasNext()) {
			Utilisateur u = (Utilisateur)it.next();
			System.out.println("util : " + util.getEmail());
			System.out.println("u : " + u.getEmail());
			if(util.getEmail().equals(u.getEmail())) {
				errors.rejectValue("email", "Création impossible", null, "Il existe déjà un utilisateur portant le même email!");
				break;
			}
		}
	}

	/**
	 * @return the utilisateurManager
	 */
	public UtilisateurManager getUtilisateurManager() {
		return utilisateurManager;
	}

	/**
	 * @param utilisateurManager the utilisateurManager to set
	 */
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

}
