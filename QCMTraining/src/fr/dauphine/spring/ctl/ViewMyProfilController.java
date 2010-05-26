/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.UtilisateurManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class ViewMyProfilController extends DefaultViewController<Utilisateur> {

	/**
	 * 
	 */
	public ViewMyProfilController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.ctl.DefaultViewController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		ModelAndView mav = constructErrorView(request);
		if(secureAccess(request)) {
			Utilisateur utilInSession = (Utilisateur)request.getSession().getAttribute(Constants.PARAM_USER_SESSION);
			utilInSession = ((UtilisateurManager)manager).read(utilInSession.getId());
			mav = constructSuccessView(request);
			mav.addObject(nameOfObject, utilInSession);
		}
		return mav;
	}

}
