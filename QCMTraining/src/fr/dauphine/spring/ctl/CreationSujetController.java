/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 * 
 */
public class CreationSujetController extends DefaultCreationController<Sujet> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = super.handleRequest(request, response);
		Sujet s = (Sujet)mav.getModel().get(nameOfObject);
		s.addNewQuestion(Constants.PARAM_DEFAULT_NUMBER_QUESTION);
		return mav;
	}
}
