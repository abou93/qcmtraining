package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Employe;
import fr.dauphine.spring.bo.Societe;
import fr.dauphine.spring.dao.EmployeDAO;

public class EmployeDAOImpl extends AbstractDAOImpl<Employe> implements EmployeDAO {

	@Override
	protected Class<Employe> getTemplateClass() {
		return Employe.class;
	}
	
	@Override
	public Employe save(Employe e) {
		if (e.getSociete() != null && e.getSociete().getId() != null) {
			Societe s = getHibernateTemplate().load(Societe.class, e.getSociete().getId());
			e.setSociete(s);
		} else {
			e.setSociete(null);
		}
		
		return super.save(e);
	}
}
