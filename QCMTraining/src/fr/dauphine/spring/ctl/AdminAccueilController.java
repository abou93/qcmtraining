/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * @author Mathieu
 *
 */

public class AdminAccueilController extends DefaultController implements Controller {
	
	/**
	 * 
	 */
	public AdminAccueilController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = constructSuccessView(request);
		return mav;
	}
}
