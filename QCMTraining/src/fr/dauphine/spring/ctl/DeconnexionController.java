/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class DeconnexionController extends DefaultController implements Controller {
	
	/**
	 * 
	 */
	public DeconnexionController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = constructSuccessView();
		request.getSession().removeAttribute(Constants.PARAM_USER_SESSION);
		request.getSession().setAttribute(Constants.PARAM_ISLOGGED, false);
		request.getSession().setAttribute(Constants.PARAM_ISADMIN, false);
		return mav;
	}

}
