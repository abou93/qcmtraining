/**
 * 
 */
package fr.dauphine.spring.bo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(Sujet.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub

	}

}
