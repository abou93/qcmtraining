/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.SujetManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class CreationParticipationController extends
		DefaultCreationController<Participation> {
	public static final String PARAM_OBJECT_SUJET = "sujetObject";
	public static final String PARAM_VIEW_NOT_ACTIF = "jsp/participation/notOpen.jsp";
	SujetManager sujetManager;
	
	/* (non-Javadoc)
	 * @see fr.dauphine.spring.ctl.DefaultController#constructViewWithNewInstance()
	 */
	/* (non-Javadoc)
	 * @see fr.dauphine.spring.ctl.DefaultCreationController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = super.handleRequest(request, response);
		String idString = request.getParameter(Constants.PARAM_REQUEST_ID);
		Utilisateur util = (Utilisateur)request.getSession().getAttribute(Constants.PARAM_USER_SESSION);
		if(StringUtils.isEmpty(idString)) {
			mav = constructErrorView();
			this.addError(request, resource.getString(PARAM_ERROR_ID_NULL));
		} else if(util == null || util.getId() == null) {
			mav = constructErrorView();
		} else {
			Long id = Long.parseLong(idString);
			Sujet sujet = this.sujetManager.read(id);
			if(!sujet.isActif()) {
				mav = constructViewWithNewInstance(PARAM_VIEW_NOT_ACTIF);
			} else {
				mav = constructSuccessViewWithNewInstance();
			}
			Participation part = (Participation)mav.getModel().get(nameOfObject);
			part.setSujet(sujet);
			
			part.setListToDisplay(sujet.getRandomListOfQuestion());
			mav.addObject(nameOfObject, part);
		}
		return mav;
	}
	
	/* (non-Javadoc)
	 * @see fr.dauphine.spring.ctl.DefaultController#constructViewWithNewInstance()
	 */
	public ModelAndView constructViewWithNewInstance(String nameOfView)
			throws InstantiationException, IllegalAccessException {
		ModelAndView mav = super.constructSuccessViewWithNewInstance();
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfView);
		return mav;
	}

	/**
	 * @return the sujetManager
	 */
	public SujetManager getSujetManager() {
		return sujetManager;
	}
	/**
	 * @param sujetManager the sujetManager to set
	 */
	public void setSujetManager(SujetManager sujetManager) {
		this.sujetManager = sujetManager;
	}
}
