/**
 * 
 */
package fr.dauphine.spring.ctl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.UtilisateurManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class ValidationUserController extends DefaultSimpleFormController<Utilisateur> {

	UtilisateurManager utilisateurManager;

	/**
	 * @return the utilisateurManager
	 */
	public UtilisateurManager getUtilisateurManager() {
		return utilisateurManager;
	}

	/**
	 * @param utilisateurManager the utilisateurManager to set
	 */
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mav = constructView();
		Utilisateur util = (Utilisateur) command;
		System.out.println(">> Utilisateur : " + util.getEmail());
		manager.save(util);
		mav.setViewName("redirect:adminAccueil.do");
		return mav;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = super.handleRequest(request, response);
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		return mav;
	}

}
