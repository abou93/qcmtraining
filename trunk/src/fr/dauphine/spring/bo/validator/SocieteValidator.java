package fr.dauphine.spring.bo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Societe;

public class SocieteValidator implements Validator {

	public boolean supports(Class<?> aClass) {
		return aClass.equals(Societe.class);
	}

	public void validate(Object o, Errors errors) {
		Societe societe = (Societe) o;
		if (societe == null) {
			errors.rejectValue("societe", "Erreur !", null, "Société nécessaire !");
		}
		else {
			if (societe.getNom() == null || societe.getNom().equals("")) {
				errors.rejectValue("nom", "Valeur manquante", null, "Il faut saisir un nom");
			}
		}
	
   	}

	
	
}
