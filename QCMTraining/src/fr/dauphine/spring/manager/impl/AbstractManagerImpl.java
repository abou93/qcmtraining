/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import java.util.Collection;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.dao.AbstractDAO;
import fr.dauphine.spring.manager.AbstractManager;

/**
 * @author Mathieu
 *
 */
public class AbstractManagerImpl<T extends BO> implements AbstractManager<T> {
	
	AbstractDAO<T> dao;
	/**
	 * 
	 */
	public AbstractManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<T> list() {
		// TODO Auto-generated method stub
		return dao.loadAll();
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}
	
	@Override
	public T update(T entity) {
		return dao.update(entity);
	}
	
	/**
	 * @return the dao
	 */
	public AbstractDAO<T> getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(AbstractDAO<T> dao) {
		this.dao = dao;
	}

	@Override
	public T read(Long id) {
		return dao.read(id);
	}

}
