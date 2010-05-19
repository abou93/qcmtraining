package fr.dauphine.spring.manager.impl;

import java.util.Collection;

import fr.dauphine.spring.bo.Employe;
import fr.dauphine.spring.bo.Societe;
import fr.dauphine.spring.dao.EmployeDAO;
import fr.dauphine.spring.dao.SocieteDAO;
import fr.dauphine.spring.manager.RepertoireManager;

public class RepertoireManagerImpl implements RepertoireManager {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 7525384147638362517L;

	private EmployeDAO employeDAO;
	
	private SocieteDAO societeDAO;

	@Override
	public Collection<Employe> loadAllEmploye() {
		return employeDAO.loadAll();
	}

	@Override
	public Collection<Societe> loadAllSociete() {
		return societeDAO.loadAll();
	}

	@Override
	public Employe saveEmploye(Employe e) {
		return employeDAO.save(e);
	}
	
	@Override
	public Societe saveSociete(Societe e) {
		return societeDAO.save(e);
	}
	
	public void setEmployeDAO(EmployeDAO employeDAO) {
		this.employeDAO = employeDAO;
	}
	
	public void setSocieteDAO(SocieteDAO societeDAO) {
		this.societeDAO = societeDAO;
	}
}
