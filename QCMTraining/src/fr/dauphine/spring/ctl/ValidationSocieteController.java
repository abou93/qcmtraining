package fr.dauphine.spring.ctl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.Societe;
import fr.dauphine.spring.manager.RepertoireManager;


@SuppressWarnings("deprecation")
public class ValidationSocieteController extends SimpleFormController {

	private RepertoireManager repertoireManager;

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
    	dataMap.put("societes", repertoireManager.loadAllSociete());
    	
    	return dataMap;

	}

	@Override
	protected ModelAndView onSubmit(
			Object command) throws Exception {

		Societe societe = (Societe) command;
		System.out.println(">> SOCIETE : " + societe.getNom());
		this.
		repertoireManager.saveSociete(societe);
		
		return super.onSubmit(command);
	}

	public void setRepertoireManager(RepertoireManager repertoireManager) {
		this.repertoireManager = repertoireManager;
	}
}
