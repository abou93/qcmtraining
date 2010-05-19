/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Profil;
import fr.dauphine.spring.dao.ProfilDAO;

/**
 * @author Mathieu
 *
 */
public class ProfilDAOImpl extends AbstractDAOImpl<Profil> implements ProfilDAO {

	/**
	 * 
	 */
	public ProfilDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Profil> getTemplateClass() {
		// TODO Auto-generated method stub
		return Profil.class;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.AbstractDAO#save(java.lang.Object)
	 */
	@Override
	public Profil save(Profil entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
