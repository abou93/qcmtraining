/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.bo.Profil;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.ParticipationManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class ViewSujetController extends DefaultViewController<Sujet> {
	public static final String LIST_PART_SANS_FAUTE = "partSansFaute";
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
			if(userInSession.getProfil().getCode() == Profil.ADMIN_CODE) {
				chargerStatistiquesSujet(mav);
			} else {
				Participation part = partManager.getParticipationByIdUserAndIdSujet(userInSession.getId(), suj.getId());
				if(part != null && part.getId() != null) {
					mav.setViewName("redirect:viewParticipation.do?" + Constants.PARAM_REQUEST_ID +"="+ part.getId());
				}
			}
		}
		return mav;
	}

	private void chargerStatistiquesSujet(ModelAndView mav) {
		Sujet suj = (Sujet)mav.getModel().get(nameOfObject);
		List<Participation> lstPartSansFaute = partManager.getParticipationSansFaute(suj.getId(), suj.getNbQuestionDisplay());
		mav.addObject(LIST_PART_SANS_FAUTE, lstPartSansFaute);
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
