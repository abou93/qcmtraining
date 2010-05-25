/**
 * 
 */
package fr.dauphine.spring.dao;

import java.util.Collection;

import org.hibernate.criterion.Order;

import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.form.SujetSearchForm;

/**
 * @author Mathieu
 *
 */
public interface SujetDAO extends AbstractSearchDAO<Sujet, SujetSearchForm> {
	
	Collection<Sujet> getListOrderBy(Order order);
}
