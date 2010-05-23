/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Participation;

/**
 * @author Mathieu
 *
 */
public class ValidationParticipationController extends
		DefaultSimpleFormController<Participation> {

	/**
	 * 
	 */
	public ValidationParticipationController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mav = constructView();
		Participation part = (Participation) command;
		manager.save(part);
		return mav;
	}
	
}
