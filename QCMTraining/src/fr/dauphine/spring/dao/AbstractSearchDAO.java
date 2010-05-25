/**
 * 
 */
package fr.dauphine.spring.dao;

import java.util.Collection;

import fr.dauphine.spring.form.AbstractSearchForm;

/**
 * @author Mathieu
 *
 */
public interface AbstractSearchDAO<T, TypeObjectForm extends AbstractSearchForm> extends AbstractDAO<T> {
	
	Collection<T> search(TypeObjectForm form);
}
