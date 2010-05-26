/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.manager.SujetManager;


/**
 * @author Mathieu
 *
 */

public class AccueilController extends DefaultController implements Controller {
	private static final String PARAM_LIST_TOP_SUJET = "listTopSujet";
	SujetManager sujetManager;
	public AccueilController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = constructSuccessView(request);
		mav.addObject(PARAM_LIST_TOP_SUJET, sujetManager.getListOrderByDesc("nombreDeParticipants"));
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
