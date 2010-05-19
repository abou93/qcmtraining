package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.Employe;
import fr.dauphine.spring.manager.RepertoireManager;

public class CreationEmployeController implements Controller {

	private RepertoireManager repertoireManager;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("employe");
		mav.addObject("societes", repertoireManager.loadAllSociete());
		mav.addObject("employes", repertoireManager.loadAllEmploye());
		mav.addObject("employe", new Employe());
		return mav;
		
	}
	
	public void setRepertoireManager(RepertoireManager repertoireManager) {
		this.repertoireManager = repertoireManager;
	}
}
