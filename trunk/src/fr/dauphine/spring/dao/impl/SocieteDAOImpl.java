package fr.dauphine.spring.dao.impl;

import fr.dauphine.spring.bo.Societe;
import fr.dauphine.spring.dao.SocieteDAO;

public class SocieteDAOImpl extends AbstractDAOImpl<Societe> implements SocieteDAO {

	@Override
	protected Class<Societe> getTemplateClass() {
		return Societe.class;
	}
}
