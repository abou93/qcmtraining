/**
 * 
 */
package fr.dauphine.spring.manager.impl;

import java.util.Collection;

import org.hibernate.criterion.Order;

import fr.dauphine.spring.bo.Category;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.dao.AbstractDAO;
import fr.dauphine.spring.dao.SujetDAO;
import fr.dauphine.spring.form.SujetSearchForm;
import fr.dauphine.spring.manager.SujetManager;

/**
 * @author Mathieu
 *
 */
public class SujetManagerImpl extends AbstractSearchManagerImpl<Sujet, SujetSearchForm> implements
		SujetManager {
	AbstractDAO<Category> categoryDao;
	/**
	 * 
	 */
	public SujetManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the categoryDao
	 */
	public AbstractDAO<Category> getCategoryDao() {
		return categoryDao;
	}
	/**
	 * @param categoryDao the categoryDao to set
	 */
	public void setCategoryDao(AbstractDAO<Category> categoryDao) {
		this.categoryDao = categoryDao;
	}
	@Override
	public Collection<Category> listeCategory() {
		return categoryDao.loadAll();
	}
	@Override
	public Collection<Sujet> getListOrderByDesc(String sortedProperty) {
		return ((SujetDAO)dao).getListOrderBy(Order.desc(sortedProperty));
	}
	

}
