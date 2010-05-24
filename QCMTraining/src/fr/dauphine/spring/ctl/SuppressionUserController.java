package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.util.Constants;

public class SuppressionUserController extends
		DefaultSuppressionController<Utilisateur> {

	public SuppressionUserController() {
		
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		ModelAndView mav = super.handleRequest(request, reponse);
		String idString = request.getParameter(Constants.PARAM_REQUEST_ID);
		Utilisateur userInSession = (Utilisateur)request.getSession().getAttribute(Constants.PARAM_USER_SESSION);
		String id = userInSession.getId().toString();
		if(idString.equals(id)) {
			mav.setViewName("redirect:deconnexion.do");
		}
		
		return mav;
	}
	
}
