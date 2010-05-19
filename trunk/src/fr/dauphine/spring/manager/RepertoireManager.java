package fr.dauphine.spring.manager;

import java.util.Collection;

import fr.dauphine.spring.bo.Employe;
import fr.dauphine.spring.bo.Societe;

public interface RepertoireManager {

	Employe saveEmploye(Employe e);
	Societe saveSociete(Societe e);
	
	Collection<Employe> loadAllEmploye();
	
	Collection<Societe> loadAllSociete();
}
