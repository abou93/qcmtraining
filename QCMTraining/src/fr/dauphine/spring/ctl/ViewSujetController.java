/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.ParticipationManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class ViewSujetController extends DefaultViewController<Sujet> {
	ParticipationManager partManager;
	/**
	 * 
	 */
	public ViewSujetController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.ctl.DefaultViewController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		ModelAndView mav = super.handleRequest(request, reponse);
		Sujet suj = (Sujet) mav.getModel().get(nameOfObject);
		Utilisateur userInSession = (Utilisateur)request.getSession().getAttribute(Constants.PARAM_USER_SESSION);
		if(userInSession != null && userInSession.getId() != null) {
			Participation part = partManager.getParticipationByIdUserAndIdSujet(userInSession.getId(), suj.getId());
			if(part != null && part.getId() != null) {
				mav.setViewName("redirect:viewParticipation.do?" + Constants.PARAM_REQUEST_ID +"="+ part.getId());
			}
		}
		return mav;
	}

	/**
	 * @return the partManager
	 */
	public ParticipationManager getPartManager() {
		return partManager;
	}

	/**
	 * @param partManager the partManager to set
	 */
	public void setPartManager(ParticipationManager partManager) {
		this.partManager = partManager;
	}
}
