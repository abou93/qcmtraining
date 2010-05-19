/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class LoginController implements Controller {

	/**
	 * 
	 */
	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		Utilisateur util = (Utilisateur)request.getSession().getAttribute(Constants.PARAM_USER_SESSION);
		if(util != null && util.getId() != null) {
			mav = new ModelAndView("jsp/template/logged");
		} else {
			mav = new ModelAndView("jsp/template/login");
			mav.addObject("utilisateur", new Utilisateur());
		}
		return mav;
	}

}
