package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.UtilisateurManager;
import fr.dauphine.spring.util.Constants;

public class CreerUserController implements Controller {

	private UtilisateurManager utilisateurManager;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("utilisateur", utilisateurManager.loadAllUtilisateur());
		mav.addObject("utilisateur", new Utilisateur());
		request.getSession().setAttribute(Constants.PARAM_PAGE_CONTENT,Constants.PARAM_CONTENT_CREERUSER);
		return mav;
		
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

}
