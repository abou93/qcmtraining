/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import fr.dauphine.spring.bo.Profil;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.dao.UtilisateurDAO;

/**
 * @author Mathieu
 *
 */
public class UtilisateurDAOImpl extends AbstractDAOImpl<Utilisateur> implements
		UtilisateurDAO {

	/**
	 * 
	 */
	public UtilisateurDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Utilisateur> getTemplateClass() {
		return Utilisateur.class;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractDAO#save(java.lang.Object)
	 */
	@Override
	public Utilisateur save(Utilisateur entity) {
		if (entity.getProfil() != null && entity.getProfil().getId() != null) {
			Profil p = getHibernateTemplate().load(Profil.class, entity.getProfil().getId());
			entity.setProfil(p);
		} else {
			entity.setProfil(null);
		}
		return super.save(entity);
	}
	
	@Override
	public Utilisateur update(Utilisateur entity) {
		if (entity.getProfil() != null && entity.getProfil().getId() != null) {
			Profil p = getHibernateTemplate().load(Profil.class, entity.getProfil().getId());
			entity.setProfil(p);
		} else {
			entity.setProfil(null);
		}
		return super.update(entity);
	}	
	
	@Override
	public boolean verifLoginAndPassword(String login, String password) {
		boolean result = false;
		Criteria crit = getSession().createCriteria(Utilisateur.class);
		crit.add(Restrictions.eq("email", login));
		Utilisateur util = (Utilisateur)crit.uniqueResult();
		if(util != null && util.getPassword().equals(password)) {
			result = true;
		}
		return result;
	}

	@Override
	public Utilisateur readByEmail(String email) {
		Criteria crit = getSession().createCriteria(Utilisateur.class);
		crit.add(Restrictions.eq("email", email));
		return (Utilisateur)crit.uniqueResult();
	}

}
