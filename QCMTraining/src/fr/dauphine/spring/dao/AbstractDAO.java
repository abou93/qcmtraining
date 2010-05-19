package fr.dauphine.spring.dao;

import java.util.Collection;

public interface AbstractDAO<T> {

	Collection<T> loadAll();
	
	T save(T entity);
	
	T read(String id);
}
