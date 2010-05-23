/**
 * 
 */
package fr.dauphine.spring.manager;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.spring.bo.BO;

/**
 * @author Mathieu
 *
 */
public interface AbstractManager<T extends BO> {

	Collection<T> list();
	T save(T entity);
	T read(Long id);
	
	@Transactional(readOnly = false)
	void delete(T entity);
	
}
