/**
 * 
 */
package fr.dauphine.spring.bo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.UtilisateurManager;

/**
 * @author Mathieu
 *
 */
public class ModificationUserValidator implements Validator {
	
	UtilisateurManager utilisateurManager;
	/**
	 * 
	 */
	public ModificationUserValidator() {
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
				errors.rejectValue("email", "Valeur manquante", null, "Il faut saisir un nom.");
			}
			if (util.getEmail() == null || util.getEmail().equals("")) {
				errors.rejectValue("email", "Valeur manquante", null, "Il faut saisir un email.");
			}
			if (util.getPassword() == null || util.getPassword().equals("")) {
				errors.rejectValue("password", "Valeur manquante", null, "Il faut saisir un password.");
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
