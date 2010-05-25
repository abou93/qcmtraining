/**
 * 
 */
package fr.dauphine.spring.manager;

import java.util.Collection;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.form.AbstractSearchForm;

/**
 * @author Mathieu
 *
 */
public interface AbstractSearchManager<T extends BO, TypeObjectForm extends AbstractSearchForm>
		extends AbstractManager<T> {
	
	Collection<T> search(TypeObjectForm form);

}
