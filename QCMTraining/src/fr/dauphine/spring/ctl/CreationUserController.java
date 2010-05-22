package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.UtilisateurManager;
import fr.dauphine.spring.util.Constants;

public class CreationUserController extends DefaultCreationController<Utilisateur> {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = super.handleRequest(request, response);
		return mav;
		
	}

}
