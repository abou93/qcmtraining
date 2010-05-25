/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Category;
import fr.dauphine.spring.dao.AbstractDAO;

/**
 * @author Mathieu
 *
 */
public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements
		AbstractDAO<Category> {

	@Override
	protected Class<Category> getTemplateClass() {
		return Category.class;
	}

}
