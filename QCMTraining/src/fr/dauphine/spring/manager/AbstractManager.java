/**
 * 
 */
package fr.dauphine.spring.manager;

import java.util.Collection;

import fr.dauphine.spring.bo.BO;

/**
 * @author Mathieu
 *
 */
public interface AbstractManager<T extends BO> {

	Collection<T> list();
	T save(T entity);
	T read(Long id);
	
	void delete(T entity);
	
	T update(T entity);
}
