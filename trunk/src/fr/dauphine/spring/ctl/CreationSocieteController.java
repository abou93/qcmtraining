package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.Societe;
import fr.dauphine.spring.manager.RepertoireManager;

public class CreationSocieteController implements Controller {

	private RepertoireManager repertoireManager;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("societe");
		mav.addObject("societes", repertoireManager.loadAllSociete());
		mav.addObject("societe", new Societe());
		return mav;
		
	}
	
	public void setRepertoireManager(RepertoireManager repertoireManager) {
		this.repertoireManager = repertoireManager;
	}
}
