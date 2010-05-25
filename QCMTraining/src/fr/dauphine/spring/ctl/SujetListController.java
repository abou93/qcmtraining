/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.form.SujetSearchForm;
import fr.dauphine.spring.manager.SujetManager;

/**
 * @author Mathieu
 *
 */
public class SujetListController extends DefautListController<Sujet, SujetSearchForm> {
	public static final String PARAM_LIST_CATEGORY = "categories";
	/* (non-Javadoc)
	 * @see fr.dauphine.spring.ctl.DefautListController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = super.handleRequest(request, response);
		mav.addObject(PARAM_LIST_CATEGORY, ((SujetManager)manager).listeCategory());
		return mav;
	}

}
