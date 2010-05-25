/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Category;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.manager.SujetManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 * 
 */
public class CreationSujetController extends DefaultCreationController<Sujet> {
	public static final String PARAM_LIST_CATEGORY = "categories";
	SujetManager sujetManager;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = super.handleRequest(request, response);
		Sujet s = (Sujet)mav.getModel().get(nameOfObject);
		mav.addObject(PARAM_LIST_CATEGORY, sujetManager.listeCategory());
		s.setCategory(new Category());
		s.addNewQuestion(Constants.PARAM_DEFAULT_NUMBER_QUESTION);
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
