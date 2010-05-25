/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import fr.dauphine.spring.bo.Category;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.dao.SujetDAO;
import fr.dauphine.spring.form.SujetSearchForm;

/**
 * @author Mathieu
 *
 */
public class SujetDAOImpl extends AbstractSearchDAOImpl<Sujet, SujetSearchForm> implements SujetDAO {

	/**
	 * 
	 */
	public SujetDAOImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Sujet> getTemplateClass() {
		return Sujet.class;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractDAO#save(java.lang.Object)
	 */
	@Override
	public Sujet save(Sujet entity) {
		if (entity.getCategory() != null && entity.getCategory().getId() != null) {
			Category cat = getHibernateTemplate().load(Category.class, entity.getCategory().getId());
			entity.setCategory(cat);
		} else {
			entity.setCategory(null);
		}
		return super.save(entity);
	}

	@Override
	protected void constructCriteria(Criteria crit, SujetSearchForm form) {
		if(form != null) {
			if(!StringUtils.isEmpty(form.getSearchTitre())) {
				crit.add(Restrictions.ilike("titre", form.getSearchTitre(), MatchMode.ANYWHERE));
			}
			if(form.getSearchInIdCategory() != null && form.getSearchInIdCategory() != 0L) {
				crit.add(Restrictions.eq("category.id", form.getSearchInIdCategory()));
			}
			if(form.isSearchActif()) {
				Date today = new Date();
				crit.add(Restrictions.le("dateStart", today));
				crit.add(Restrictions.ge("dateEnd", today));
			}
		}
	}

}
