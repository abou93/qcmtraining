/**
 * 
 */
package fr.dauphine.spring.manager;

import java.util.Collection;

import fr.dauphine.spring.bo.Category;
import fr.dauphine.spring.bo.Sujet;

/**
 * @author Mathieu
 *
 */
public interface SujetManager extends AbstractManager<Sujet> {
	Collection<Category> listeCategory();
}
