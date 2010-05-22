/**
 * 
 */
package fr.dauphine.spring.bo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.dauphine.spring.bo.Question;
import fr.dauphine.spring.bo.Reponse;
import fr.dauphine.spring.bo.Sujet;

/**
 * @author Mathieu
 * 
 */
public class SujetValidator implements Validator {

	/**
	 * 
	 */
	public SujetValidator() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(Sujet.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		Sujet sujet = (Sujet) obj;
		if (sujet == null) {
			errors.rejectValue("sujetForm", "Erreur!", null,
					"Le sujet de QCM est absent.");
		} else {
			if (sujet.getDateStart() == null) {
				errors.rejectValue("dateStart", "Valeur manquante!", null,
						"La date de lancement est obligatoire.");
			}
			if (sujet.getDateEnd() == null) {
				errors.rejectValue("dateEnd", "Valeur manquante!", null,
						"La date de fin est obligatoire.");
			}
			if (sujet.getTitre() == null || sujet.getTitre().isEmpty()) {
				errors.rejectValue("titre", "Valeur manquante!", null,
						"Le titre du QCM est obligatoire.");
			}
			for (short i = 0; i < sujet.getListQuestion().size(); i++) {
				Question question = sujet.getListQuestion().get(i);
				if (question.getLibelle() == null
						|| question.getLibelle().isEmpty()) {
					errors.rejectValue("listQuestion[" + i + "].libelle",
							"Valeur manquante!", null,
							"Le libellé de la question n°" + (i + 1)
									+ " est obligatoire.");
				}
				for (short j = 0; j < question.getListResponse().size(); j++) {
					Reponse rep = question.getListResponse().get(j);
					if (rep.getLibelle() == null || rep.getLibelle().isEmpty()) {
						errors.rejectValue("listQuestion[" + i
								+ "].listResponse[" + j + "].libelle",
								"Valeur manquante!", null,
								"Le libellé de la réponse n°" + (j + 1)
										+ " à la question n°" + (i + 1)
										+ " est obligatoire.");
					}
				}
			}
		}
	}

}
