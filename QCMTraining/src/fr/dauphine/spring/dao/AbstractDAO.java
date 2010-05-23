package fr.dauphine.spring.dao;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

public interface AbstractDAO<T> {

	Collection<T> loadAll();
	
	T save(T entity);
	
	T read(Long id);
	
	@Transactional(readOnly = false)
	void delete(T entity);
}
