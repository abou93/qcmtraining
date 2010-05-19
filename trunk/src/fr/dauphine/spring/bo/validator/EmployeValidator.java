package fr.dauphine.spring.bo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Employe;

public class EmployeValidator implements Validator {

	public boolean supports(Class<?> aClass) {
		return aClass.equals(Employe.class);
	}

	public void validate(Object o, Errors errors) {
		Employe employe = (Employe) o;
		if (employe == null) {
			errors.rejectValue("employe", "Erreur !", null, "Employé nécessaire !");
		}
		else {
			if (employe.getNom() == null || employe.getNom().equals("")) {
				errors.rejectValue("nom", "Valeur manquante", null, "Il faut saisir un nom");
			}
		}
	
   	}

	
	
}
